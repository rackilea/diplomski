public void put(E e) throws InterruptedException {
    checkNotNull(e);
    final ReentrantLock lock = this.lock;
    lock.lockInterruptibly();
    try {
        // Do stuff.
        enqueue(e);
    } finally {
        lock.unlock();
    }
}