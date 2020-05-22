public boolean checkUser(String username, String password) throws SQLException {
    //acquire a java.sql.DataSource; the DataSource is typically a connection pool that's set-up in the application of obtained via jndi
    DataSource dataSource = acquireDataSource();
    //java 7 try-with-resources statement is used to make sure that resources are properly closed
    //obtain a connection from the pool. Upon closing the connection we return it to the pool
    try (Connection connection = dataSource.getConnection()) {
        //release resources associated with the PreparedStatement as soon as we no longer need it.
        try(PreparedStatement ps = connection.prepareStatement("SELECT username, password FROM morleys_user WHERE username=? AND password=? AND isActive=1 LIMIT 1");){
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();
            return resultSet.next();
        }
    }
}