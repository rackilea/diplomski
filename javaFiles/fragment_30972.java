public static ResultSet executeStatement(Connection connection, 
    Statement statement, String s) {
  ResultSet resultSet = null;
  try {
    if (statement != null) {
      resultSet = statement.executeQuery(s);
    }
  } catch (SQLException e) {
    System.out.println("A SQLException occured executing the Statement");
    e.printStackTrace();
  } catch (IOException e) {
    System.out.println("A IOException occured executing the Statement");
    e.printStackTrace();
  } catch (PropertyVetoException e) {
    System.out.println("A PropertyVetoException occured executing the Statement");
    e.printStackTrace();
  }
  return resultSet;
}