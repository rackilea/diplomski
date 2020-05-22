public class CassandraSessionSingleton {
    private static CassandraSessionSingleton cassandraSessionSingleton = null;

    public Session session;

    private CassandraSessionSingleton(ClusterBuilder clusterBuilder) {
        Cluster cluster = clusterBuilder.getCluster();
        session = cluster.connect();
    }

    public static CassandraSessionSingleton getInstance(ClusterBuilder clusterBuilder) {
        if (cassandraSessionSingleton == null)
            cassandraSessionSingleton = new CassandraSessionSingleton(clusterBuilder);
        return cassandraSessionSingleton;
    }

}