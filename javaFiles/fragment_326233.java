private ReadWriteLock rwl = new ReentrantReadWriteLock();

public void writeSomething() {
   rwl.writeLock().lock();
   try {
      //Modify/write something
   } finally {
      rwl.writeLock().unlock();
   }
}

public String readSomething() {
   rwl.readLock().lock();
   try {
      //Read something
   } finally {
      rwl.readLock().unlock();
   }
}