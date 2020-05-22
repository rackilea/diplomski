Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
try 
{
  connection = getConnection();
  statement = connection.prepareStatement(...);
  resultSet = statement.executeQuery();

  ...
}
finally
{
  SQLUtils.closeQuietly(resultSet);
  SQLUtils.closeQuietly(statment);
  SQLUtils.closeQuietly(connection);
}