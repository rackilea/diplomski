private volatile Thread lastThread;
private final ReentrantLock lock = new ReentrantLock();

private void doBackgroundTask(Object obj) throws InterruptedException {
    Thread currentThread = Thread.currentThread();
    lastThread = currentThread;
    try {
        // wait until lock available
        lock.lockInterruptibly();
        // if a thread has arrived in the meantime, exit and release the lock
        if (lastThread != currentThread) return; 
        // otherwise
        // perform long task here that is only being run by one thread
        // and also only accepts the last queued thread
    } finally {
        lock.unlock();
    }
}