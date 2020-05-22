@Service
public class AsyncFias {
    private static final Logger log = LoggerFactory.getLogger(AsyncFias.class);

    private final FiasFileService fiasFileService;
    private final MongoDBService mongoDBService;

    private AtomicBoolean inProgress = new AtomicBoolean(false);

    private AtomicInteger count = new AtomicInteger(0);

    AsyncFias(FiasFileService fiasFileService, MongoDBService mongoDBService) {
        this.fiasFileService = fiasFileService;
        this.mongoDBService = mongoDBService;
    }

    public Integer getIncrement(){
        return count.get();
    }

    @Async("threadPoolTaskExecutor")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Future<Void> startUpdate(File file) throws InterruptedException {
        DbfUtilEnum utilEnum = DbfUtilEnum.fromFileName(file.getName().toLowerCase());
        DbfMapper<Document> objMapper = utilEnum.getDbfMapper();
        List<Document> dbObjects = fiasFileService.processFile(file, objMapper);
        String collectionName = utilEnum.getCollectionName();
        EntryMetaInfo metaInfo = new EntryMetaInfo(collectionName, collectionName, null, false, null);
        List<List<Document>> lists = ListUtils.partition(dbObjects, 1000);
        if (inProgress.compareAndSet(false, true)) {
            for (List<Document> it : lists) {
                //Thread.sleep(2000);
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Cancelled");
                    inProgress.set(false);
                    break;
                }
                mongoDBService.insertBulk(metaInfo, it);
                count.getAndIncrement();
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    AsyncResult<Void> result = new AsyncResult<>(null);
                    result.cancel(true);
                    return result;
                }
            }
        }
        lists.clear();
        count.set(0);
        AsyncResult<Void> result = new AsyncResult<>(null);
        result.cancel(true);
        return result;
    }
}

@Service
public class FiasQueryServiceImpl implements FiasQueryService {
    private Future<Void> asyncResult;
    // a lot of code
    @Override
    public Document updateFiasByFileName(String fileName) throws NotFinishProcessException, InterruptedException {
        String settingsPath = settingsService.getStringParam(FIAS_FILE_PATH);
        File file = new File(settingsPath + "/" + fileName);
        ObjectId objectId = checkAndInsertStatus(file.getName().toLowerCase());
        asyncResult = asyncFias.process(file);
        return new Document("_id", objectId.toString()).append("success", true);
    }
    @Override
    public Document interrupt(String objectIdString) {
        asyncResult.cancel(true);

        if (asyncResult.isCancelled()) {
            log.info("asyncResult.isCancelled()");
            ObjectId objectId = new ObjectId(objectIdString);
            setStatus(objectId, INTERRUPT);
            return new Document("success", true).append("count", asyncFias.getIncrement());
        } else {
            return new Document("success", false);
        }
    }
}