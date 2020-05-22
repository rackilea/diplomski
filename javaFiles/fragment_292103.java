private final ReentrantLock lock = new ReentrantLock();

      public void sampleLock() {
        lock.lock();
        try {
          Thread.sleep(5000);
        } catch (InterruptedException e) {
          System.out.println(Thread.currentThread().getName() + "interrupted");
        }
        lock.unlock();
      }