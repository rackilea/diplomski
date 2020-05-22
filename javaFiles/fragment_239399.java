public Connection getConnection(String user, String password) throws SQLException {
    try {
      Connection con = DriverManager.getConnection(getUrl(), user, password);
      if (LOGGER.isLoggable(Level.FINE)) {
        LOGGER.log(Level.FINE, "Created a {0} for {1} at {2}", new Object[]{getDescription(), user, getUrl()});
      }
      return con;
    } catch (SQLException e) {
      LOGGER.log(Level.SEVERE, "Failed to create a {0} for {1} at {2}: {3}",
          new Object[]{getDescription(), user, getUrl(), e});
      throw e;
    }
}