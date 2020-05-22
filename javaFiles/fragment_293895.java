private ReadWriteLock lock = new ReentrantReadWriteLock();
private Lock readLock = lock.readLock();
private Lock writeLock = lock.writeLock();

public PropertyDescriptor getPropertyDescriptor(final Class<?> clazz, final String propertyName) throws Exception {
    readLock.lock();
    try {
        ...
    } finally {
        readLock.unlock();
    }
}

public void flushDirectory(final ClassLoader cl) {
    writeLock.lock();
    try {
        ...
    } finally {
        writeLock.unlock();
    }
}