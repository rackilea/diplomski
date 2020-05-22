public class Updater implements Runnable {

    private final WorkerThreadListener mWorkerThreadListener;
    private final Handler mHandler;

    private int count = 0;

    public Updater(final WorkerThreadListener workerThreadListener) {
        this.mWorkerThreadListener = workerThreadListener;
        this.mHandler = new Handler();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                count++;
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mWorkerThreadListener.onUpdate(count);
                    }
                });
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}