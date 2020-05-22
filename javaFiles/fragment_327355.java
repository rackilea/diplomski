public enum ConnectionManager {
    INSTANCE;

    private DataSource ds = null;
    private Lock connectionLock = new ReentrantLock();

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

      Connection conn = null;
      connectionLock.lock();
      try {
          conn = ds.getConnection();
      } finally {
          connectionLock.unlock();
      }

      return conn;
   }
}