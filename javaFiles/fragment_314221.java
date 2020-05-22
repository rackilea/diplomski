public class SomeProcessFunction implements ProcessFunction <Object, ResultSet> {
    ClusterBuilder secureCassandraSinkClusterBuilder;

    // Constructor
    public SomeProcessFunction (ClusterBuilder secureCassandraSinkClusterBuilder) {
        this.secureCassandraSinkClusterBuilder = secureCassandraSinkClusterBuilder;
    }

    @Override
    public void  ProcessElement (Object obj) throws Exception {
        ResultSet resultSet = CassandraLookUp.cassandraLookUp("SELECT * FROM TEST", secureCassandraSinkClusterBuilder);
        return resultSet;
    }
}