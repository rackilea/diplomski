oracle.jdbc.pool.OracleDataSource ds = new oracle.jdbc.pool.OracleDataSource();
ds.setDriverType("thin");
ds.setServerName("localhost");
ds.setPortNumber(1521);
ds.setDatabaseName("XE"); // Oracle SID
Connection con = ds.getConnection(user, password);