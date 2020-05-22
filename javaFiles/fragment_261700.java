// create the count down latch and initialize it to 1 as we wait for one background thread to finish
final CountDownLatch cdl = new CountDownLatch(1);

// Start the background thread and give it a reference to the count down latch
final Thread thread = new Thread(new Runnable {
   public void run() {
     try {
       // do work here
     } finally {
       cdl.countDown();
     }
   }
}
thread.start();

// We wait till the background thread completes
cdl.await();