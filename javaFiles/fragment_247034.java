public void run() {
   try {
      while( !Thread.currentThread().isInterrupted() ) {
          doSomeThreadedThing();
      }
   } catch( InterruptedException e ) {
      // maybe log some info you are shutting down
   }
}