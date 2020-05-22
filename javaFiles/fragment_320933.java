ReadWriteLock trial = new ReentrantReadWriteLock(fair);
ReadWriteLock lock = locks.putIfAbsent(key, trial);
if (lock == null) {
  /* The current thread won the race to create lock for key. */
  lock = trial;
}