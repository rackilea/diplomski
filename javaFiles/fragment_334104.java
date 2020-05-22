public class RealmRunnable implements Runnable {
    private Runnable mOrigRunnable;
    private DiskDataSource mDiskDataSource;

    public RealmRunnable(DiskDataSource diskDataSource, Runnable origRunnable) {
        mDiskDataSource = diskDataSource;
        mOrigRunnable = origRunnable;
    }

    @Override
    public void run() {
        try {
            mOrigRunnable.run();
        } finally {
            mDiskDataSource.closeDatabaseInstance();
        }
    }
}