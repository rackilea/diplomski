Lock lock = ...;
if (lock.tryLock(10L, TimeUnit.SECONDS)) {
    try {
        // manipulate protected state
    } finally {
        lock.unlock();
    }
} else {
      // perform alternative actions
}