MysqlDataSource ds = new MysqlDataSource();
ds.setServerName("localhost");
ds.setPort("3306");
ds.setDatabaseName("testdb");
ds.setUser("root");
ds.setPassword("");
Connection connection = ds.getConnection();