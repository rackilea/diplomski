private MysqlDataSource dataSource;

public void connect() {
    this.dataSource = new MysqlDataSource()
    // Set dataSource Properties
    dataSource.setServerName("localhost");
    dataSource.setPortNumber(3306);
    dataSource.setDatabaseName("andrea");
    dataSource.setUser("andrea");
    dataSource.setPassword("password");
    // Continue from here
}