try (final Connection poolConn = DataSourceConnectionPool.getConnection()) {
    final Connection conn = poolConn.unwrap(OracleConnection.class);
    //do stuff with conn
    //do not close conn!!
}
//poolConn is returned to the pool