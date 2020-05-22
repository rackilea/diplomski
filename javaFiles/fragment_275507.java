final ReadWriteLock rwLock = new ReentrantReadWriteLock();

public void doSomething() {
    rwLock.writeLock().lock();
    try {
        doStuff();
    } finally {
        rwLock.writeLock().unlock();
    }
}