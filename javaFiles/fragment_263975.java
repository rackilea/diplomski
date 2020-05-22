@Configuration
@EnableIntegration
@IntegrationComponentScan
public class DataMigrationModule {

private final Logger log = LoggerFactory.getLogger(getClass());

@Value("${cloud.aws.credentials.accessKey}")
private String accessKey;

@Value("${cloud.aws.credentials.secretKey}")
private String secretKey;

@Value("${cloud.aws.s3.bucket}")
private String bucket;

@Value("${cloud.aws.s3.max-objects-per-batch:1024}")
private int maxObjectsPerBatch;

@Value("${cloud.aws.s3.accept-subfolders:false}")
private String acceptSubFolders;

@Value("${cloud.aws.s3.remote-directory}")
private String remoteDirectory;

@Value("${cloud.aws.s3.local-directory-ref:java.io.tmpdir}")
private String localDirectoryRef;

@Value("${cloud.aws.s3.local-subdirectory:target/s3-dump}")
private String localSubdirectory;

@Value("${cloud.aws.s3.filename-wildcard:}")
private String fileNameWildcard;

@Value("${app.persistent-type:}")
private String persistentType;

@Value("${app.repository-type:}")
private String repositoryType;

@Value("${app.persistence-batch-size:2500}")
private int persistenceBatchSize;

@Value("${app.persistence-batch-release-timeout-in-milliseconds:5000}")
private int persistenceBatchReleaseTimeoutMillis;

@Autowired
private ListableBeanFactory beanFactory;

@Autowired
private ObjectMapper objectMapper;

private final AtomicBoolean invoked = new AtomicBoolean();

private Class<?> repositoryType() {
    try {
        return Class.forName(repositoryType);
    } catch (ClassNotFoundException cnfe) {
        log.error("Unknown repository implementation!", cnfe);
        System.exit(0);
    }
    return null;
}

private Class<?> persistentType() {
    try {
        return Class.forName(persistentType);
    } catch (ClassNotFoundException cnfe) {
        log.error("Unsupported type!", cnfe);
        System.exit(0);
    }
    return null;
}

public Date nextExecutionTime(TriggerContext triggerContext) {
    return this.invoked.getAndSet(true) ? null : new Date();
}

@Bean
public FileToInputStreamTransformer unzipTransformer() {
    FileToInputStreamTransformer transformer = new FileToInputStreamTransformer();
    transformer.setDeleteFiles(true);
    return transformer;
}

@Bean
public MessageSource<?> amazonS3InboundSynchronizationMessageSource() {
    AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
    AmazonS3InboundSynchronizationMessageSource messageSource = new AmazonS3InboundSynchronizationMessageSource();
    messageSource.setCredentials(credentials);
    messageSource.setBucket(bucket);
    messageSource.setMaxObjectsPerBatch(maxObjectsPerBatch);
    messageSource.setAcceptSubFolders(Boolean.valueOf(acceptSubFolders));
    messageSource.setRemoteDirectory(remoteDirectory);
    if (!fileNameWildcard.isEmpty()) {
        messageSource.setFileNameWildcard(fileNameWildcard);
    }
    String directory = System.getProperty(localDirectoryRef);
    if (!localSubdirectory.startsWith("/")) {
        localSubdirectory = "/" + localSubdirectory;
    }
    if (!localSubdirectory.endsWith("/")) {
        localSubdirectory = localSubdirectory + "/";
    }
    directory = directory + localSubdirectory;
    FileUtils.mkdir(directory);
    messageSource.setDirectory(new LiteralExpression(directory));
    return messageSource;
}

@Bean
public IntegrationFlow mainFlow() {
    // @formatter:off
    return IntegrationFlows
            .from(
                    amazonS3InboundSynchronizationMessageSource(),
                    e -> e.poller(p -> p.trigger(this::nextExecutionTime))
            )
            .transform(unzipTransformer())
            .split(new FileSplitter(), null)
            .publishSubscribeChannel(new SimpleAsyncTaskExecutor(), p -> p.subscribe(persistenceSubFlow()))
            .get();
    // @formatter:on
}

@Bean
public IntegrationFlow persistenceSubFlow() {
    JsonObjectMapper<?, ?> jsonObjectMapper = new Jackson2JsonObjectMapper(objectMapper);
    ReleaseStrategy releaseStrategy = new TimeoutCountSequenceSizeReleaseStrategy(persistenceBatchSize,
            persistenceBatchReleaseTimeoutMillis);
    // @formatter:off
    return f -> f
            .transform(Transformers.fromJson(persistentType(), jsonObjectMapper))
            // @see http://docs.spring.io/spring-integration/reference/html/messaging-routing-chapter.html#agg-and-group-to
            .aggregate(
                    a -> a
                        .releaseStrategy(releaseStrategy)
                        .correlationStrategy(m -> m.getHeaders().get("id"))
                        .expireGroupsUponCompletion(true)
                        .sendPartialResultOnExpiry(true)
                        , null
            )
            .handle(jdbcRepositoryHandler());
    // @formatter:on
}

@Bean
public JdbcRepositoryHandler jdbcRepositoryHandler() {
    return new JdbcRepositoryHandler(repositoryType(), beanFactory);
}

protected class JdbcRepositoryHandler extends AbstractMessageHandler {

    @SuppressWarnings("rawtypes")
    private Insertable repository;

    public JdbcRepositoryHandler(Class<?> repositoryClass, ListableBeanFactory beanFactory) {
        repository = (Insertable<?>) beanFactory.getBean(repositoryClass);
    }

    @Override
    protected void handleMessageInternal(Message<?> message) {
        repository.insert((List<?>) message.getPayload());
    }

}

protected class FileToInputStreamTransformer extends AbstractFilePayloadTransformer<InputStream> {

    @Override
    protected InputStream transformFile(File payload) throws Exception {
        return new GZIPInputStream(new FileInputStream(payload));
    }
}

}