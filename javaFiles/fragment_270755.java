preparedStatement = connection.prepareStatement("SELECT id FROM user WHERE username=? AND password=MD5(?)");
preparedStatement.setString(1, username);
preparedStatement.setString(2, password);
resultSet = preparedStatement.executeQuery();

if (resultSet.next()) {
    pagename = "main";
}
else {
    pagename = "start";
}