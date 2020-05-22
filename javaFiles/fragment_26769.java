ConcurrentMap<String, ReadWriteLock> lockMap = new ConcurrentHashMap<>();

ReadWriteLock getLock(String key) {
    ReadWriteLock lock = lockMap.get(key);
    if (lock == null) {
        lock = new ReentrantReadWriteLock();
        ReadWriteLock other = lockMap.putIfAbsent(key, lock);
        if (other != null) {
            // another thread's putIfAbsent won
            lock = other;
        }
    }
    return lock;
}