@Component
public class MyLoaderClass {

    // Autowire in this with constructor injection or @Autowired
    private MyLoaderClass myLoaderClass;

    // Removed @Transactional annotation
    public void loadErUp() {
        myLoaderClass.loadPartition(holder, zdt);
        ...
    }

    // 1) Add the @Transactional annotation to #loadPartition
    // 2) Make public to use self-autowiring (or refactored class, per link above)
    @Transactional
    public <T> long loadPartition(long partitionKey, ZonedDateTime zdt) {
        ...
        // Can remove TransactionSyncManager call
        ...
    }

}