public class SomeConnectionPool
{
   private static final Logger log = Logger.getLogger (SomeConnectionPool.class.getName());
   private static SomeConnectionPool instance = new SomeConnectionPool ();
   private SomeDataSource sDS = null;

   private SomeConnectionPool ()
   {
     // Configure DataSource, connect to DB
      this.sDs = new SomeDataSource (config);
   }
   public static SomeConnectionPool getInstance ()
   {
     return instance;
   }
   public SomeDataSource getDataSource ()
   {
      return this.sDs;
   }