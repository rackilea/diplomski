public insertUser(String name, String email) {
   Connection conn = null;
   PreparedStatement stmt = null;
   try {
      conn = setupTheDatabaseConnectionSomehow();
      stmt = conn.prepareStatement("INSERT INTO person (name, email) values (?, ?)");
      stmt.setString(1, name);
      stmt.setString(2, email);
      stmt.executeUpdate();
   }
   finally {
      try {
         if (stmt != null) { stmt.close(); }
      }
      catch (Exception e) {
         // log this error
      }
      try {
         if (conn != null) { conn.close(); }
      }
      catch (Exception e) {
         // log this error
      }
   }
}