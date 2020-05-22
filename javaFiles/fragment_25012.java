class Test {

    private volatile Thread lastThread;
    private final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws Exception {
        final Test instance  = new Test();
        Runnable r = new Runnable() {

            @Override
            public void run() {
                try {
                    instance.doBackgroundTask(null);
                } catch (InterruptedException ignore) {}
            }
        };
        Thread t1 = new Thread(r, "T1");
        Thread t2 = new Thread(r, "T2");
        Thread t3 = new Thread(r, "T3");
        t1.start();
        Thread.sleep(100);
        t2.start();
        Thread.sleep(100);
        t3.start();
    }

    private void doBackgroundTask(Object obj) throws InterruptedException {
        Thread currentThread = Thread.currentThread();
        System.out.println("[" + currentThread.getName() + "] entering");
        lastThread = currentThread;
        try {
            // wait until lock available
            lock.lockInterruptibly();
            // if a thread has arrived in the meantime, exit and release the lock
            if (lastThread != currentThread) return;
            // otherwise
            // perform long task here that is only being run by one thread
            // and also only accepts the last queued thread
            System.out.println("[" + currentThread.getName() + "] Thinking deeply");
            Thread.sleep(1000);
            System.out.println("[" + currentThread.getName() + "] I'm done");
        } finally {
            lock.unlock();
            System.out.println("[" + currentThread.getName() + "] exiting");
        }
    }
}