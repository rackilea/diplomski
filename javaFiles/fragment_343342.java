Cluster cluster = CouchbaseCluster.create("127.0.0.1");
ClusterManager clusterManager = cluster.clusterManager("Administrator", "12345");
BucketSettings bucketSettings = new DefaultBucketSettings.Builder()
        .type(BucketType.COUCHBASE)
        .name("hello")
        .quota(120)
        .build();

clusterManager.insertBucket(bucketSettings);