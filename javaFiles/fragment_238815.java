public boolean doesAccountWithThatUsernameExist(User user) throws SQLException {
    boolean doesThatUsernameExist = false;
    PreparedStatement preparedStatement = connection.prepareStatement("SELECT username FROM user WHERE username=?"); // < that's wrong
    preparedStatement.setString(1, user.getName());
    ResultSet result = preparedStatement.executeQuery();
    doesThatUsernameExist = result.next();
    return doesThatUsernameExist;
}