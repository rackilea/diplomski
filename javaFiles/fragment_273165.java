public ComboPooledDataSource dataSource(String driver, String url, String username,String password) throws PropertyVetoException {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setDriverClass(driver);
    dataSource.setJdbcUrl(url);
    dataSource.setUser(username);
    dataSource.setPassword(password);

    dataSource.setAcquireIncrement(1);
    dataSource.setMaxPoolSize(100);
    dataSource.setMinPoolSize(1);
    dataSource.setInitialPoolSize(1);
    dataSource.setMaxIdleTime(300);
    dataSource.setMaxConnectionAge(36000);

    dataSource.setAcquireRetryAttempts(5);
    dataSource.setAcquireRetryDelay(2000);
    dataSource.setBreakAfterAcquireFailure(false);

    dataSource.setCheckoutTimeout(30000);
    dataSource.setPreferredTestQuery("SELECT 1");
    dataSource.setIdleConnectionTestPeriod(60);
    return dataSource;
}//in order to do a "clean" shutdown you should call datasource.close() when shutting down your web app.