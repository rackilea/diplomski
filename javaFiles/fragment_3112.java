lock.lock();
try {
    // code including monitor.signal() here
} finally {
    lock.unlock();
}