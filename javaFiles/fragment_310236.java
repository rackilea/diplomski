private static final class MyBarrierWithLock {

    private boolean hasWorkFlag = false;

    private final Lock lock = new ReentrantLock();
    private final Condition hasWorkCond = lock.newCondition();

    void await() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (!hasWorkFlag) {
                hasWorkCond.await();
            }
            hasWorkFlag = false;
        } finally {
            lock.unlock();
        }
    }

    void signal() {
        lock.lock();
        try {
            hasWorkFlag = true;
            hasWorkCond.signalAll(); // or signal() if we are sure there is 1 signal thread and 1 worker thread
        } finally {
            lock.unlock();
        }
    }
}