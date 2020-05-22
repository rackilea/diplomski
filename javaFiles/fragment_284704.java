public void writeProcessing(String var) {
    lock = getLockForVar(var);
    ...
}

private ReadWriteLock getLockForVar(String var) {
   ReadWriteLock lock = lockMap.get(var);
    if (lock != null) {
        return lock;
    }
    // this might create an extra lock because of race conditions...
    lock = new ReadWriteLock();
    ReadWriteLock current = lockMap.putIfAbsent(var, lock);
    if (current == null) {
        return lock;
    } else {
        return current;
    }
}