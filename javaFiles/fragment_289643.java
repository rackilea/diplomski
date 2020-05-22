public void reset() {
    lock.lock();
    try {
        cached = null;
        wasCleared = true;
    } finally {
         lock.unlock();
    }
}