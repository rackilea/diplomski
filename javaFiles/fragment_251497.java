public User find(String username, String password) throws SQLException {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    User user = null;

    try {
        connection = database.getConnection();
        statement = connection.prepareStatement("SELECT id, username, email, firstname, lastname, FROM user WHERE username = ? AND password = MD5(?)");
        statement.setString(1, username);
        statement.setString(2, password);
        resultSet = statement.executeQuery();

        if (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getLong("id"));
            user.setUsername(resultSet.getString("username"));
            user.setEmail(resultSet.getString("email"));
            user.setFirstname(resultSet.getString("firstname"));
            user.setLastname(resultSet.getString("lastname"));
        }
    } finally {
        close(resultSet, statement, connection);
    }

    return user;
}