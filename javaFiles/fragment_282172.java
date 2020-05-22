@Bean
public PoolingDataSource setupPoolingDataSource() {
    PoolingDataSource pds = new PoolingDataSource();
    pds.setUniqueName("jdbc/jbpm");
    pds.setClassName("bitronix.tm.resource.jdbc.lrc.LrcXADataSource");
    pds.setMaxPoolSize(50);
    pds.setAllowLocalTransactions(true);
    pds.getDriverProperties().put("user", "username");
    pds.getDriverProperties().put("password", "password");
    pds.getDriverProperties().put("url", "jdbc:mysql://localhost/databaseName?useUnicode=yes&characterEncoding=UTF-8&useSSL=false");
    pds.getDriverProperties().put("driverClassName", "com.mysql.jdbc.Driver");
    pds.init();
    return pds;
}