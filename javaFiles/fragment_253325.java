if (!running) {
    synchronized (mLock) {
        running = true;
        mLock.notify();
    }
}