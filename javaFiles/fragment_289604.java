Thread threadX = new Thread( new Runnable() {
     public void run() {
       try {
       while(true) {
         Thread.sleep(100);
         System.err.println("In threadX");
       }
       } catch (InterruptedException e) {
         System.err.println("ThreadX interrupted and exiting...");
         // Restore the interrupted status 
         // not really needed here as we know the thread is exiting
         // but a good practice all the same. (So callers know 
         // we've been interrupted.)
         Thread.currentThread().interrupt();
       }
    }
  });

  threadX.start();
  Thread.sleep(1000);
  threadX.interrupt();