public static final Object mutex = new Object();
    public static boolean finished = false;

    // One thread
    synchronized (mutex) {
        while (!finished) {
             mutex.wait();
        }
    }

    // Another thread
    synchronized (mutex) {
        finished = true;
        mutex.notify();
    }