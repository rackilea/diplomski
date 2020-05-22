int code = 0;
// ...
resultSet = statement.executeQuery();
if (resultSet.next()) {
    code = resultSet.getInt("Code");
}
// ...