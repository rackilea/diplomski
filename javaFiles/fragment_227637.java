/**
 *
 * @author Brenden Towey
 */
public class FutureExample
{

   public static void main( String[] args )
   {
      ExecutorService exe = Executors.newFixedThreadPool(3);
      List<Future<String>> results = new ArrayList<>();
      for( int i = 0; i < 5; i++ )
         results.add( exe.submit( new HtmlTask() ) );
      try {
         for( Future<String> future : results )
             System.out.println( future.get() );
      } catch( InterruptedException x ) {
         // bail
      } catch( ExecutionException ex ) {
         Logger.getLogger( FutureExample.class.getName() ).
                 log( Level.SEVERE, null, ex );
         // and bail
      }
      exe.shutdown();
      boolean shutdown = false;
      try {
         shutdown = exe.awaitTermination(10 , TimeUnit.SECONDS );
      } catch( InterruptedException ex ) {
         // bail
      }
      if( !shutdown ) {
         exe.shutdownNow();
         try {
            exe.awaitTermination( 30, TimeUnit.SECONDS );
         } catch( InterruptedException ex ) {
            // just exit
         }
      }
   }
}

class HtmlTask implements Callable<String> {

   @Override
   public String call()
           throws Exception
   {
      // pretend to search a website and return some result
      return "200 OK";
   }

}