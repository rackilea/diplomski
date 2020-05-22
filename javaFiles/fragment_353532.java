public class Test {

    private static int NUM_OF_THREADS = 100000;
    // Keep track of my thread.
    private Thread thread;

    public void loopSomeTime() {
        thread = new Thread(new Runnable() {
            public void run() {
                int count = 0;
                for (int i = 0; i < 1000000; ++i) {
                    count++;
                }
                System.out.println(count);
            }
        });
        thread.start();

    }

    public void waitToFinish() throws InterruptedException {
        thread.join();
    }

    public static void main(String[] args) throws InterruptedException {
        List<Test> loopers = new ArrayList<>();
        long beginTime = System.nanoTime();
        for (int i = 0; i < NUM_OF_THREADS; i++) {
            Test d = new Test();
            d.loopSomeTime();
            // Keep track of all loopers.
            loopers.add(d);
        }
        //I need to wait here
        for (Test t : loopers) {
            t.waitToFinish();
        }
        long endTime = System.nanoTime() - beginTime;
        System.out.println(endTime / (1000 * 1000) + "milliseconds");
    }
}