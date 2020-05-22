class Outer {
    final Object lock = new Object();

    public void method() {
        synchronized(lock) {
            // do something
            lock.notifyAll();
        }
    }

    class Inner implements Runnable {
         public void run() {
              while(!Thread.currentThread().isInterrupted()) {
                 synchronized(lock) {
                     lock.wait();
                     // check if anything changed.
                 }
              }
         }
    }
}