// class lass level declarations
private static int DEF_VALUE = 500;
private static int MIN_VALUE = 0;
private static int MAX_VALUE = 1000;

private AtomicInteger i = new AtomicInteger(DEF_VALUE);
private Thread t1 = null;
private Thread t2 = null;

private void initThreads() {
    Log.i(TAG, "Initializing Threads...");

    t1 = new Thread(new Runnable() {

        @Override
        public void run() {
            Log.i(TAG, "Starting T1.");
            while (i.get() < MAX_VALUE) {
                i.incrementAndGet();
                Log.d(TAG, String.format("Incremented by T1, i = %d", i.get()));
            }
            Log.i(TAG, "Finishing T1.");
        }
    });

    t2 = new Thread(new Runnable() {

        @Override
        public void run() {
            Log.i(TAG, "Starting T1.");
            while (i.get() > MIN_VALUE) {
                i.decrementAndGet();
                Log.d(TAG, String.format("Decremented by T2, i =  %d", i.get()));
            }
            Log.i(TAG, "Finishing T2.");
        }
    });

    t1.start();
    t2.start();
}