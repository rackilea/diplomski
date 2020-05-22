public String requestWithRetry(final Object params, long timeout, TimeUnit unit) throws InterruptedException {
    String[] result = new String[1];
    CountDownLatch latch = new CountDownLatch(1);
    Thread t = new Thread(new Runnable() {
      public void run() {
        while (true) {
          try {
            result[0] = request(params);
            latch.countDown();
            return;
          }
          catch(OtherException oe) {
            // ignore and retry
          }
          catch(InterruptedException ie) {
            // task was cancelled; terminate thread
            return;
          }
        }
      }
    });
    t.start();
    try {
      if (!latch.await(timeout, unit)) {
        t.interrupt(); // cancel the background task if timed out
      }
      // note that this returns null if timed out
      return result[0];
    }
    catch(InterruptedException ie) {
      t.interrupt(); // cancel the background task
      throw ie;
    }
  }

  private String request(Object params) throws OtherException, InterruptedException {
    // should handle interruption to cancel this operation
    return null;
  }