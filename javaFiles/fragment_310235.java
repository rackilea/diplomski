private static final class MyBarrierWithSynchronized {

    private boolean hasWork = false;

    synchronized void await() throws InterruptedException {
        while (!hasWork) {
            wait();
        }
        hasWork = false;
    }

    synchronized void signal() {
        hasWork = true;
        notifyAll(); // or notify() if we are sure there is 1 signal thread and 1 worker thread
    }
}