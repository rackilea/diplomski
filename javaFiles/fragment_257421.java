while (true) {
  // try to acquire the lock, wait 500ms until the lock owner t_A release the lock
  boolean acquired = lock.tryLock(500, TimeUnit.MILLISECONDS);
  if (acquired) {
    try {
      //do the job
    } finally {
      lock.unlock();
    }
  }else{
    // t_A is already running, output a log for example
  }
}