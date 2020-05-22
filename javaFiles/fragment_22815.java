public DataSource getDataSource() {
     HikariConfig config = new HikariConfig();
     config.setMaximumPoolSize(10);
     config.setDataSourceClassName("com.microsoft.sqlserver.jdbc.SQLServerDataSource");
     config.addDataSourceProperty("serverName", this.serverName);
     config.addDataSourceProperty("port", this.portNumber);
     config.addDataSourceProperty("databaseName", this.databaseName);
     config.addDataSourceProperty("user", this.userName);
     config.addDataSourceProperty("password", this.password);

     return new HikariDataSource(config);  //pass in HikariConfig to HikariDataSource
}