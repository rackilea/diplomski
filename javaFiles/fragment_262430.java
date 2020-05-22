private final Lock lock = new ReentrantLock();
...

if (lock.tryLock(1L, TimeUnit.SECONDS)) {
   try {
      // we were able to lock
   } finally {
      // always unlock in a finally
      lock.unlock();
   }
} else {
   // trying to lock timed out without locking
}