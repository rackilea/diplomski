public abstract class AbstractThread extends Thread {

    protected Runnable runnable;

    protected AbstractThread(String name, Runnable runnable) {
        super(runnable, name);

        this.runnable = runnable;
    }

    /**
     * This method provides a way to perform some action before the thread is actually starting.
     */
    protected abstract void beforeExecution();

    /**
     * This method provides a way to perform some action after the thread finished.
     */
    protected abstract void afterExecution();

    @Override
    public void run() {
        try {
            doRun();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Run the given runnable here.
     * 
     * @throws InterruptedException 
     */
    protected abstract void doRun() throws InterruptedException;

}