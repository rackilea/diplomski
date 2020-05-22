import com.datastax.spark.connector.cql.CassandraConnector;

CassandraConnector connector = CassandraConnector.apply(spark.sparkContext().conf()); // or pass different values for spark.cassandra.connection.host, username and password

rdd.foreach(new VoidFunction<TestBean>() {
        @Override
        public void call(TestBean t) throws Exception {
            final String id = t.getId();
            final Map<String, String> mappings = t.getMappings();
            boolean isUpdated = connector.withSessionDo(new AbstractFunction1<Session, Boolean>() {
                @Override
                public Boolean apply(Session v1) {
                    ResultSet updateResultSet = v1.execute(v1.prepare("update test set mappings = mappings + ? where id = ?")
                            .setConsistencyLevel(ConsistencyLevel.LOCAL_QUORUM)
                            .bind(mappings, id));
                    return updateResultSet.wasApplied();
                }
            });
        }
    });