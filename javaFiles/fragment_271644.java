ds = new BasicDataSource();
    ds.setDriverClassName("com.mysql.jdbc.Driver");
    ds.setUsername("root");
    ds.setPassword("root");
    ds.setUrl("jdbc:mysql://localhost/test");
    ...
    // then later in the application:
    Connection conn = ds.getConnection();
    // do the stuff
    conn.close(); // only releases conn back to pool
    ...
    // or better in Java 7:
    try (Connection conn = ds.getConnection()) {
          // do the stuff
    }