final V put(K key, int hash, V value, boolean onlyIfAbsent) {
    HashEntry<K,V> node = tryLock() ? null : scanAndLockForPut(key, hash, value);
    V oldValue;
    try {
       // modifications
    } finally {
        unlock();
    }
    return oldValue;
}

private HashEntry<K,V> scanAndLockForPut(K key, int hash, V value) {
    // ...
    int retries = -1; // negative while locating node
    while (!tryLock()) {
        if (retries < 0) {
            // ...
        }
        else if (++retries > MAX_SCAN_RETRIES) {
            lock();
            break;
        }
        else if ((retries & 1) == 0 && (f = entryForHash(this, hash)) != first) {
            e = first = f; // re-traverse if entry changed
            retries = -1;
        }
    }
    return node;
}