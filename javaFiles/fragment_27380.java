class MyThread extends Thread implements Runnable {
  public Throwable exception; // a copy of any exceptions are stored here

  public void run() {
    try {
      throw new Exception("This is a test");
    }
    catch (Throwable e) {
      // An exception has been thrown.  Ensure we have exclusive access to
      // the exception variable
      synchronized(this) {
        exception = e; // Store the exception
        notify();      // Tell the calling thread that exception has been updated
      }
      return;
    }

    // No exception has been thrown        
    synchronized(this) {
      // Tell the calling thread that it can stop waiting
      notify();
    }
  }
} 

MyThread t = new MyThread();




t.start();
synchronized(t) {
  try {
    System.out.println("Waiting for thread...");
    t.wait();
    System.out.println("Finished waiting for thread.");
  }
  catch (Exception e) {
    fail("wait() resulted in an exception"); 
  }
  if (t.exception != null) {
    throw t.exception;
  }
  else {
    System.out.println("Thread completed without errors");
  }
}


try {
  System.out.println("Waiting to join thread...");
  t.join();
  System.out.println("Joined the thread");
}
catch (Exception e) {
  System.out.println("Failed to join thread");
}