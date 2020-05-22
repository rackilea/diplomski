private final V LOCK = ...; // a fake value
// if a key is mapped to LOCK, that means the key is locked
ConcurrentMap<K,V> map = ...;

V lock(key)
    V value;  
    while( (value=map.putIfAbsent(key, LOCK))==LOCK )
        // another thread locked it before me
        wait();
    // now putIfAbsent() returns a real value, or null
    // and I just sucessfully put LOCK in it
    // I am now the lock owner of this key
    return value; // for caller to work on

// only the lock owner of the key should call this method
unlock(key, value)
    // I put a LOCK on the key to stall others
    // now I just need to swap it back with the real value
    if(value!=null) 
        map.put(key, value);
    else // map doesn't accept null value
        map.remove(key)
    notifyAll();

test()
    V value = lock(key);

    // work on value

    // unlock. 
    // we have a chance to specify a new value here for the next worker
    newValue = ...; // null if we want to remove the key from map
    unlock(key, newValue); // in finally{}