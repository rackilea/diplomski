public class MySubmoduleThread extends Thread {
    ...
    private MySubmodule mSubmodule;
    private CountDownLatch mLatch; // shared latch object accross tasks
    public MySubModuleThread(CountDownLatch latch) {
        mLatch = latch;
    }
    ...
    @Override
    public final void run() {
        mSubmodule.initialize();
        mLatch.countDown(); // count 1 down
        mSubmodule.run();
    }
}

public class MyApp extends Application {
    ...
    @Override
    public void onCreate() {
        super.onCreate();
        int nrOfTasks = /* N */;
        CountDownLatch latch = new CountDownLatch(nrOfTasks);
        mSubmoduleThread1 = new SubModuleThread(latch);
        mSubmoduleThread2 = new SubModuleThread(latch);
        ...
        mSubmoduleThread1.start();
        mSubmoduleThread2.start();
        ...
        mSubmoduleThreadN.start();

        latch.await(); // wait that countdown reaches 0 (needs some try catch)

    }