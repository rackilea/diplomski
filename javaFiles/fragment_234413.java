@Singleton
public class Couchbase {
    private static ALogger logger = Logger.of(Couchbase.class);

    private final Cluster cluster;
    private final Bucket bucket;

    @Inject
    public Couchbase(ApplicationLifecycle lifecycle, Configuration configuration) {
        // Read the database configuration from the setting.
        final String clusterName = configuration.getString("couchbase.cluster");
        final String bucketName = configuration.getString("couchbase.bucket.name");
        final String bucketPassword = configuration.getString("couchbase.bucket.password");

        final CouchbaseEnvironment env = DefaultCouchbaseEnvironment
                .builder()
                .queryEndpoints(1)
                .autoreleaseAfter(50000)
                .queryTimeout(20000)
                .retryStrategy(FailFastRetryStrategy.INSTANCE)
                .reconnectDelay(Delay.fixed(5, TimeUnit.SECONDS))
                .build();

        logger.debug(
                "Connect to the couche: cluster \"{}\", bucket: \"{}\"", 
                clusterName, 
                bucketName);

        // Connect.
        cluster = CouchbaseCluster.create(env, clusterName);
        bucket = cluster.openBucket(bucketName, bucketPassword);

        // Create a default index.
        bucket.bucketManager().createN1qlPrimaryIndex(true, false);

        // Special operations on the application shutdown.
        lifecycle.addStopHook(() -> {

            // Close the connection on application shutdown.
            env.shutdown();
            cluster.disconnect();

            // Couchbase close the connection synchronously 
            // so we need just return an empty CompletableFuture.
            return CompletableFuture.completedFuture(null);
        });        
    }

    /**
     * @return  the application bucket
     */
    public Bucket getBucket() {
        return bucket;
    }
}