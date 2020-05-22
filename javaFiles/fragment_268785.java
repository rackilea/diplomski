private final ReentrantLock lock = new ReentrantLock();
public void add(final ResultRecord result) {
    lock.lock();
    try {
        AddNotThreadSafe(result); // Only one thread add in same time. Now is safe for executing. 
    } finally {
        lock.unlock();
    }
}