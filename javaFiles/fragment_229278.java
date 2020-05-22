public class SomeConnectionPool
{
   private static final Logger log = Logger.getLogger (SomeConnectionPool.class.getName());
   private static SomeDataSource sDS = new SomeDataSource (config);
   private static SomeConnectionPool sCP = new SomeConnectionPool ();

   private SomeConnectionPool ()
   {
     // Configure DataSource, connect to DB
   }