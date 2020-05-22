mouseClickedLock.readLock().lock();
try {
    // Your code here
} finally {
    mouseClickedLock.readLock().unlock();
}