Map<String, ReadWriteLock> lockMap =
    new ConcurrentHashMap<String, ReadWriteLock>():
...
public void writeProcessing(String var) {
    lock = lockMap.get(var);
    lock.writeLock().lock;
    try {
       // Processing
    } finally {
       lock.writeLock().unlock();
    }
}