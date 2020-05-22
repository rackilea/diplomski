class Worker implements Runnable {
    private static final double WRITE_PROB = 0.5;
    private static final Random rand = new Random();
    private final ReadWriteLock theLock;
    private final int id;

    public Worker(int id, ReadWriteLock lock) {
        theLock = lock;
        this.id = id;
    }

    public void run() {
        message("Started.");
        while(!Thread.currentThread().isInterrupted()) {
            performAction();
        }
    }

    private void message(String msg) {
        System.out.println("Worker " + id + ": " + msg);
    }

    private void read() {
        try {
            theLock.acquireReadLock();
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        // perform read
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        finally { theLock.releaseReadLock(); }
        message("Finished reading.");
    }

    private void write() {
        try {
            theLock.acquireWriteLock();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        // perform write
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        finally { theLock.releaseWriteLock(); }
        message("Finished writing.");
    }

    private void performAction() {
        double r = rand.nextDouble();
        if (r <= WRITE_PROB) {
            write();
        } else {
            read();
        }
    }
}