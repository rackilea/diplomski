@Bean
public DataSource dataSource() {
    HikariDataSource ds = new HikariDataSource();
    ds.setPoolName("springHikariCP");
    ds.setMaxPoolSize(20);
    ds.setLeakDetectionThreshold(5000);
    ds.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
    ds.addDataSourceProperty("url", url);
    ds.addDataSourceProperty("user", username);
    ds.addDataSourceProperty("password", password);
    ds.addDataSourceProperty("cachePrepStmts", true);
    ds.addDataSourceProperty("prepStmtCacheSize", 250);
    ds.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
    ds.addDataSourceProperty("useServerPrepStmts", true);
    ds.addDataSourceProperty("verifyServerCertificate", false);
    ds.addDataSourceProperty("useSSL", true);
    ds.addDataSourceProperty("requireSSL", true);

    return ds;
}