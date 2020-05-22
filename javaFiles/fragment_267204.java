final Object fooLock = new Object();

public foo(final ConcurrentHashMap concurrentMap) {
    synchronized (fooLock) {
        //Your code here
    }
}