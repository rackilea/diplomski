Connection connection;
try {
    connection = DriverManager.getConnection(...);
    // Do statement stuff that may throw exceptions
} catch (SQLException e) {
   // Handle exception
} finally {
  // Close connection
  if (connection != null) { // Available inside finally,
      connection.close(); // because declared outside the try block
  }
}