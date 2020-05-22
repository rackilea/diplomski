MysqlDataSource ds = new MysqlDataSource();
ds.setServerName(serverName);
ds.setDatabaseName(mydatabase);
ds.setUser(username);
ds.setPassword(password);
connection = ds.getConnection();