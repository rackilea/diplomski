AtomicReference<V> fCachedValue = new AtomicReference<>();

public V getLazy() {
    V result = fCachedValue.get();
    if (result == null) {
        result = costlyIdempotentOperation();
        if (!fCachedValue.compareAndSet(null, result)) {
            return fCachedValue.get();
        }
    }
    return result; 
}