command = "SELECT user AS UserName, email FROM users WHERE email LIKE ?";
statement = connection.prepareStatement(command);
String bindVar = em1 + "%";
statement.setString(1,bindVar);
resultSet = statement.executeQuery();
if (resultSet.next()) {
    usr = resultSet.getString("UserName");
} else {
    ... error handling, not found
}