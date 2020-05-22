class Worker {
    // We need a reference to the thread to wake it
    private Thread workerThread = null;
    // Is there work available
    AtomicBoolean workAvailable = new AtomicBoolean(false);

    public void run() {
        workerThread = Thread.currentThread();
        while (!shuttingDown()) {
           step();
        }
    }

    private synchronized void step() {
        // Wait until work is available or 60 seconds have passed
        ThreadSupport.parkNanos(TimeUnit.MINUTES.toNanos(1));
        if (workAvailable.getAndSet(false)) {
            doIt();
        }
    }

    public wakeMeUpInside() {
        // NOTE: potential race here depending on desired semantics.
        // For example, if doIt() will do all work we don't want to
        // set workAvailable to true if the doIt loop is running.
        // There are ways to work around this but the desired
        // semantics need to be specified. 
        workAvailable.set(true);
        ThreadSupport.unpark(workerThread);
    }
}