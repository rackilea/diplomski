try (Connection connection = getConnection();
     Statement statement = connection.createStatement()) {
  int result = statement.executeUpdate("TRUNCATE " + tableName);
  connection.commit();
  return result;
}