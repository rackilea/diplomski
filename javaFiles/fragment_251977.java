try (
  Connection connection = getConnection();
  PreparedStatement statement = connection.prepareStatement(...);
  ResultSet resultSet = statement.executeQuery()
)
{
  ...
}