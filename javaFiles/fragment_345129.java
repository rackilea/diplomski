import java.util.concurrent.* ;

ExecutorService svc = Executors.newFixedThreadPool( 1 ) ;
svc.submit( new Runnable() {
  public void run() {
    // Do long running task
  }
} ) ;
svc.shutdown() ;
svc.awaitTermination( 300, TimeUnit.SECONDS ) ;