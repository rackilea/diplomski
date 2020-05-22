public class CassandraLookUp {
    public static ResultSet cassandraLookUp(String query, ClusterBuilder clusterBuilder) {
        CassandraSessionSingleton cassandraSessionSingleton = CassandraSessionSingleton.getInstance(clusterBuilder);
        Session session = cassandraSessionSingleton.session;
        ResultSet resultSet = session.execute(query);
        return resultSet;
    }
}