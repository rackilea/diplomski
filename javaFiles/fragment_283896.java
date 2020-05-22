@Bean
public DataSource poiDataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setMaxActive(100);
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("**");
    dataSource.setUsername("**");
    dataSource.setPassword("**");
    dataSource.setTestOnBorrow(true);
    dataSource.setValidationQuery("SELECT 1");
    dataSource.setMaxActive(30);
    dataSource.setRemoveAbandoned(true);
    dataSource.setMaxWait(60000);
    dataSource.setTimeBetweenEvictionRunsMillis(300000);
    dataSource.setMinEvictableIdleTimeMillis(300000);
    dataSource.setTestWhileIdle(true);
    dataSource.setLogAbandoned(true);
    return dataSource;
}