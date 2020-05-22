public class UserFetcher {
   private final DbConnection conn;

   public UserFetcher(DbConnection conn) { 
      this.conn = conn;
   }

   public List<User> getUsers() {
      return conn.fetch(...);
   }
}