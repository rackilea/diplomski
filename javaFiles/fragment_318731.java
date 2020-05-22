private static final Object LOCK = new Object();

public void processTask() {
    synchronized (LOCK) {
        t += 5;
    }

}