BasicDataSource ds= new BasicDataSource();
ds.setDriverClassName("org.postgresql.Driver");
ds.setUrl("jdbc:postgresql://localhost/testdb");
ds.setUsername("dbuser");
ds.setPassword("dbpassword");

Connection connection = ds.getConnection();