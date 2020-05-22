Object lock = new Object();
Object pending = null;

public void post(Object message) {
    synchronized (lock) {
        pending = message;
        lock.notifyAll();
    }
}

public Object getNextMessage() {
    Object message;
    synchronized (lock) {
        while (pending == null) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                // Ignore
            }
        }
        message = pending;
        pending = null;
    }
    return message;
}