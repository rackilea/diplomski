public class Main
{
    public static final Object lock = new Object();
    private static long l = 0;

    public static void SyncLock()
    {
        synchronized (lock) {
            ++l;
        }
    }

    public static synchronized void SyncFunction()
    {
        ++l;
    }

    public static class ThreadSyncLock implements Runnable
    {
        @Override
        public void run()
        {
            for (int i = 0; i < 10000; ++i) {
                SyncLock();
            }
        }
    }

    public static class ThreadSyncFn implements Runnable
    {
        @Override
        public void run()
        {
            for (int i = 0; i < 10000; ++i) {
                SyncFunction();
            }
        }
    }

    public static void main(String[] args)
    {
        l = 0;
        try {
            java.util.ArrayList<Thread> threads = new java.util.ArrayList<Thread>();
            long start, end;
            double avg1 = 0, avg2 = 0;
            for (int x = 0; x < 1000; ++x) {
                threads.clear();
                for (int i = 0; i < 8; ++i) { threads.add(new Thread(new ThreadSyncLock())); }
                start = System.currentTimeMillis();
                for (int i = 0; i < 8; ++i) { threads.get(i).start(); }
                for (int i = 0; i < 8; ++i) { threads.get(i).join(); }
                end = System.currentTimeMillis();
                avg1 += ((end - start) / 1000f);
                l = 0;
                threads.clear();
                for (int i = 0; i < 8; ++i) { threads.add(new Thread(new ThreadSyncFn())); }
                start = System.currentTimeMillis();
                for (int i = 0; i < 8; ++i) { threads.get(i).start(); }
                for (int i = 0; i < 8; ++i) { threads.get(i).join(); }
                end = System.currentTimeMillis();
                avg2 += ((end - start) / 1000f);
                l = 0;
            }
            System.out.format("avg1: %f s\navg2: %f s\n", (avg1/1000), (avg2/1000));
            l = 0;
        } catch (Throwable t) {
            System.out.println(t.toString());
        }
    }
}