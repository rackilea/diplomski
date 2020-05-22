public T getObject() {
    if (!available.isEmpty()) {
        synchronized(this) {
            T o = available.remove(0);
            inUse.add(o);
        }
        return o;
    }
    ....