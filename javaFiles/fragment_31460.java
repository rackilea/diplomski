public class UserFetcher {
   private final DbConnection conn = 
      new DbConnection("10.167.1.25", "username", "password");

   public List<User> getUsers() {
      return conn.fetch(...);
   }
}