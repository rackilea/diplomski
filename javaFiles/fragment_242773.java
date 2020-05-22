public class CutrePool{
      String connString;    
      String user;
      String pwd;

      static final int INITIAL_CAPACITY = 50;
      LinkedList<Connection> pool = new LinkedList<Connection>();
      public String getConnString() {
          return connString;
      }
      public String getPwd() {
          return pwd;
      }

      public String getUser() {
          return user;
      }

      public CutrePool(String connString, String user, String pwd) throws SQLException {
          this.connString = connString;

          for (int i = 0; i < INITIAL_CAPACITY; i++) {
               pool.add(DriverManager.getConnection(connString, user, pwd));
          }
          this.user = user;
          this.pwd = pwd;
      }

      public synchronized Connection getConnection() throws SQLException {
          if (pool.isEmpty()) {
              pool.add(DriverManager.getConnection(connString, user, pwd));
          }
          return pool.pop();
      }

      public synchronized void returnConnection(Connection connection) {
          pool.push(connection);
      }  
  }