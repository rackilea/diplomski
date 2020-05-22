final Lock lock = new ReentrantLock();

public void doSomething() {
    lock.lock();
    try {
        doStuff();
    } finally {
        lock.unlock();
    }
}