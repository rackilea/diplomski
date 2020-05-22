private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

public void call1SB() {
    if(lock.writeLock().tryLock()) { 
    // Acquires the write lock only if it 
    // is not held by another thread at the time of invocation.
        stlsb.doSomething();
    } // else { return; } // do nothing if already locked
}