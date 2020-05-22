public class MyLock implements java.util.concurrent.locks.Lock {

    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        while (isLocked)
            wait();
        isLocked = true;
    }

    public synchronized void unlock() {
        if (!isLocked)
            throw new IllegalStateException();
        isLocked = false;
        notify();
    }    

}