public DataSource getDataSource() {
      final HikariDataSource ds = new HikariDataSource(); 
      ds.setMaximumPoolSize(10);
      ds.setDataSourceClassName("com.microsoft.sqlserver.jdbc.SQLServerDataSource");
     // ds.addDataSourceProperty("serverName", this.serverName);
     //ds.addDataSourceProperty("databaseName", this.databaseName);
      ds.addDataSourceProperty("url", this.getConnectionUrl());
      ds.addDataSourceProperty("user", this.userName);
      ds.addDataSourceProperty("password", this.password);
      ds.setInitializationFailFast(true);
      ds.setPoolName("wmHikariCp");
      return ds;
   }