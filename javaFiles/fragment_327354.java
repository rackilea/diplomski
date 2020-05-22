public enum ConnectionManager {
    INSTANCE;

    private DataSource ds = null;

    ConnectionManager() {
      try {
         final Context initCtx = new InitialContext();
         final Context envCtx = (Context) initCtx.lookup("java:comp/env");
         ds = (DataSource) envCtx.lookup("jdbc/ConnectionManager");
      } catch (NamingException e) {
         e.printStackTrace();
      }
    }

   public Connection getConnection() throws SQLException {
      if(ds == null) return null;

      return ds.getConnection();
   }
}