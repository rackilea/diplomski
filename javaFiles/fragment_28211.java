Lock lock = ...
lock.acquire();
try {
    // do stuff
} finally {
    lock.release();
}