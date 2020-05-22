this.barrier = new CyclicBarrier(count,
   new Runnable() {
      @Override
      public void run() {
         // signal your master thread, update values, etc.
      }
    }
 );