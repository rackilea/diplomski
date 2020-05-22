class Worker {
    // If 0 there's no work available
    private workAvailableSem = new Semaphore(0);

    public void run() {
        while (!shuttingDown()) {
           step();
        }
    }

    private synchronized void step() {
        // Try to obtain a permit waiting up to 60 seconds to get one
        boolean hasWork = workAvailableSem.tryAquire(1, TimeUnit.MINUTES);
        if (hasWork) {
            doIt();
        }
    }

    public wakeMeUpInside() {
        workAvailableSem.release(1);
    }
}