connection = database.getConnection();
preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE username=? AND password=md5(?)");
preparedStatement.setString(1, username); 
preparedStatement.setString(2, password);
resultSet = preparedStatement.executeQuery();

if (resultSet.next()) {
    // Match found!
} else {
    // No match!
}