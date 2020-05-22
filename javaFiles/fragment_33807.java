class DataRunnable implements Runnable {
    private final Runnable child;

    DataRunnable(Runnable aChild) { child = aChild; }

    @Override
    public void run() {
        child.run();
        Data.removeOldDataForThisThread();
    }
}