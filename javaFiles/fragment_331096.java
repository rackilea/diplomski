BasicDataSource dbcp = new BasicDataSource();
dbcp.setDriverClassName("com.mysql.jdbc.Driver");
dbcp.setUrl("jdbc:mysql://localhost/test");
dbcp.setUsername("");
dbcp.setPassword("");

JdbcTemplate jt = new JdbcTemplate(dbcp);
jt.execute("SELECT 1");
jt.execute("SELECT 1");