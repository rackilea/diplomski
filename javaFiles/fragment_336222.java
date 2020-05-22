...
synchronized (semaphore) {
    try {
        // do your stuff
    } finally {
        semaphore.release();
    }
}