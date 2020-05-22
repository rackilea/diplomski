item.lock.lock();
try {
    ...
    item.condition.signal();
} finally {
     item.lock.unlock();
}