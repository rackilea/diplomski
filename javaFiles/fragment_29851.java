Map<Integer, Lock> map = new HashMap<>();

static class Lock {
    int count = 1;
}

void func(int i) {
    Object lock = getLock(i);
    try {
        synchronized (lock) {
            //
        }
    } finally {
        releaseLock(i);
    }
}

private synchronized Object getLock(int i) {
    Lock lock = map.get(i);
    if (lock != null) {
        lock.count++;
    } else {
        lock = new Lock();
        map.put(i, lock);
    }
    return lock;
}

private synchronized void releaseLock(int i) {
    Lock lock = map.get(i);
    if (--lock.count == 0) {
        map.remove(i);   
    }
}