public class UserFetcher {
   private final DbConnection conn;

   @Inject //or @Autowired for Spring
   public UserFetcher(DbConnection conn) { 
      this.conn = conn;
   }

   public List<User> getUsers() {
      return conn.fetch(...);
   }
}