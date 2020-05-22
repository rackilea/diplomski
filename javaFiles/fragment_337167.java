reentrantLock.lock();
try {
    condition.await();
} finally {
    reentrantLock.unlock();
}