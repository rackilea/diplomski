Lock lock = Integer.class.getLock();
boolean acquired = false;
try {
    if(lock.owner != Thread.currentThread()) {
        lock.acquire();
        acquired = true;
    }

    ...code inside of synchronized block...
} finally {
    if(acquired) lock.release();
}