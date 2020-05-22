public void run() {
    . . .
    // decide to suspend thread execution:
    synchronized (LOCK) {
        try {
            LOCK.wait();
        } catch (InterruptedException e) {
            // thread was interrupted -- time to return?
        }
    }
    // execution resumes here after interrupt or notify
}