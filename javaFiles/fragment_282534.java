public class TestX {

    private final ExecutorService pool = Executors.newFixedThreadPool(3);
    private final int N = 10;

    // all sensors are read sequentially and put in one row
    public void testSequential() {
        int total = 0;
        long t = System.currentTimeMillis();

        for (int i = 0; i < N; i++) {
            System.out.println("starting iteration " + i);

            int v1 = getSensorA();    // run in main thread
            int v2 = getSensorB();    // run in main thread
            int v3 = getSensorC();    // run in main thread

            // collection.add( record(v1, v2, v3)
            total += v1 + v2 + v3;
        }

        System.out.println("total = " + total + "   time = " + (System.currentTimeMillis() - t) + " ms");
    }

    // all sensors are read concurrently and then put in one row
    public void testParallel() throws ExecutionException, InterruptedException {
        int total = 0;
        long t = System.currentTimeMillis();

        final SensorCallable s1 = new SensorCallable(1);
        final SensorCallable s2 = new SensorCallable(3);
        final SensorCallable s3 = new SensorCallable(3);

        for (int i = 0; i < N; i++) {
            System.out.println("starting iteration " + i);

            Future<Integer> future1 = pool.submit(s1);  // run in thread 1
            Future<Integer> future2 = pool.submit(s2);  // run in thread 2
            Future<Integer> future3 = pool.submit(s3);  // run in thread 3

            int v1 = future1.get();
            int v2 = future2.get();
            int v3 = future3.get();

            // collection.add( record(v1, v2, v3)
            total += v1 + v2 + v3;
        }

        System.out.println("total = " + total + "   time = " + (System.currentTimeMillis() - t) + " ms");
    }

    private class SensorCallable implements Callable<Integer> {

        private final int sensorId;

        private SensorCallable(int sensorId) {
            this.sensorId = sensorId;
        }

        @Override
        public Integer call() throws Exception {
            switch (sensorId) {
                case 1: return getSensorA();
                case 2: return getSensorB();
                case 3: return getSensorC();
                default:
                    throw new IllegalArgumentException("Unknown sensor id: " + sensorId);
            }
        }
    }

    private int getSensorA() {
        sleep(700);
        return 1;
    }

    private int getSensorB() {
        sleep(500);
        return 2;
    }

    private int getSensorC() {
        sleep(900);
        return 2;
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new TestX().testSequential();
        new TestX().testParallel();
    }
}