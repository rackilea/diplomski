public class GraphDbStarter {
    private static GraphDatabaseService graphdb=null;

    protected GraphDbStarter()
    {}

 //   static GraphDatabaseService graphDB = new GraphDatabaseFactory().newEmbeddedDatabase("C:\\Users\\Jovo\\Documents\\NetBeansProjects\\DebtSolutions\\build\\web\\NEO4J databases\\db1"); 
   public static GraphDatabaseService getInstance()
   {
       if(graphdb == null) {
        graphdb = new GraphDatabaseFactory().newEmbeddedDatabase("C:\\Users\\Jovo\\Documents\\NetBeansProjects\\DebtSolutions\\build\\web\\NEO4J databases\\db1");
         registerShutdownHook(graphdb);  
       }

   return graphdb;
   }

   private static void registerShutdownHook(final GraphDatabaseService graphdb )
   {
   Runtime.getRuntime().addShutdownHook(new Thread()
   {    

       @Override
    public void run()
    {
    graphdb.shutdown();
    }
   });
   }
}