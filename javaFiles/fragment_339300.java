// do not attempt double-check locking here. I mean it.
synchronized(StaticObject) {
    data = StaticCache.get(key);
    while (data == IN_PROGRESS) {
        // another thread is getting the data
        StaticObject.wait();
        data = StaticCache.get(key);
    }
    if (data == null) {
        // we must get the data
        StaticCache.put(key, IN_PROGRESS, TIME_MAX_VALUE);
    }
}
if (data == null) {
    // we must get the data
    try {
        data = server.DoSlowThing(key);
    } finally {
        synchronized(StaticObject) {
            // WARNING: failure here is fatal, and must be allowed to terminate
            // the app or else waiters will be left forever. Choose a suitable
            // collection type in which replacing the value for a key is guaranteed.
            StaticCache.put(key, data, CURRENT_TIME);
            StaticObject.notifyAll();
        }
    }
}