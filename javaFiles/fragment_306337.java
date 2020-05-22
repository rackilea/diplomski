private final ReentrantLock reentrantLock = new ReentrantLock();

public void aCoolMethod(){
    if (reentrantLock.tryLock()){
        try {
            doSomething();
        } finally {
            reentrantLock.unlock();
            synchronized (reentrantLock) {
                reentrantLock.notifyAll();
            }
        }
    } else {
        // have threads wait until reentrantLock is unlocked
        synchronized (reentrantLock) {
            while(reentrantLock.isLocked()) {
                try {
                    reentrantLock.wait();
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    doSomethingElse();
}