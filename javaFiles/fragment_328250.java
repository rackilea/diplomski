public abstract class StoppableRunnable implements Runnable {
    private volatile boolean stopWork;
    private boolean done;

    public final void run() {
        setup();
        while(!stopWork && !done) {
            doUnitOfWork();
        }
        cleanup();
    }

    /**
     * Safely instructs this thread to stop working,
     * letting it finish it's current unit of work,
     * then doing any necessary cleanup and terminating
     * the thread.  Notice that this does not guarentee
     * the thread will stop, as doUnitOfWork() could
     * block if not properly implemented.
     */
    public void stop() {
        stopWork = true;
    }

    protected void done() {
        done = true;
    }

    protected void setup() { }
    protected void cleanup() { }

    /**
     * Does as small a unit of work as can be defined
     * for this thread.  Once there is no more work to
     * be done, done() should be called.
     */
    protected abstract void doUnitOfWork();
}