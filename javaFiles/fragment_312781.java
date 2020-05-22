final ReadWriteLock lock = new ReentrantReadWriteLock();

// equivalent to using @Lock(LockType.READ)
public void readData() {
  lock.readLock().lock();
  try {
    // read some data
  } finally {
    lock.readLock().unlock();
} 

// equivalent to using @Lock(LockType.WRITE)
public void writeData() {
  lock.writeLock().lock();
  try {
    // write some data
  } finally {
    lock.writeLock().unlock();
}