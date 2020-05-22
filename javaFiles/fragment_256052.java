// There should only ever be one of these.
private static final DataSource ds = makeDataSource();

private static DataSource makeDataSource() {
    ComboPooledDataSource cpds = new ComboPooledDataSource();
    cpds.setDriverClass("net.ucanaccess.jdbc.UcanaccessDriver");
    // loads the jdbc driver
    cpds.setJdbcUrl("jdbc:ucanaccess://"
            + (new File("Ressources/filter.mdb").getAbsolutePath()));
    cpds.setUser("admin");
    cpds.setPassword("ibnsina");
    cpds.setAutoCommitOnClose(false);
    return cpds;
}

private static Connection getConnection () {
    return ds.getConnection();
}

private static void releaseConnection (Connection conn) {
    conn.commit();
    conn.close();
}

private static void updating() {
    Connection conn = getConnection();
    try {
        //...
    } finally {
        releaseConnection(conn);
    }
}