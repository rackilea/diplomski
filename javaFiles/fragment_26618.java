private int foo = 0;

private ReadWriteLock rwLock = /* use some implementation of ReadWriteLock here */;

public int get() {
    Lock l = rwLock.readLock();
    int result = 0;
    l.lock();
    try {
        result = this.foo;
    }
    catch(Exception ex) {
        // may throw the Exception here
    }
    finally {
        l.unlock();
    }
    return result;
}

public void set(int bar){ 
    Lock l = rwLock.writeLock();
    l.lock();
    try {
        this.foo = bar;
    }
    catch(Exception ex) {
        // may throw the Exception here
    }
    finally {
        l.unlock();
    }
}