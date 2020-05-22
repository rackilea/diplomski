item.lock.lock();
try {
    ...
    item.condition.await();
} finally {
     item.lock.unlock();
}