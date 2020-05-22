public class ExecutorServiceTest {
    private int numThreads;
    private ExecutorService pool;
    private volatile boolean interruptedBitSet;
    private static final CountDownLatch latch = new CountDownLatch(1);

    @Before
    public void setUp() {
        numThreads = 5;
        pool = Executors.newFixedThreadPool(numThreads);
    }

    class TaskChecksForInterruptedBit implements Callable<String> {
        @Override
        public String call() throws Exception {
            interruptedBitSet = false;
            latch.countDown();
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(System.currentTimeMillis());
            }
            System.out.println("haha");
            interruptedBitSet = Thread.currentThread().isInterrupted();
            return "blah";
        }
    }

    @Test
    public void testCancelSetsInterruptedBitInCallable() throws Exception {
        final Future<String> future =
                pool.submit(new TaskChecksForInterruptedBit());
        interruptedBitSet = false;
        latch.await();
        final boolean wasJustCancelled = future.cancel(true);
        Assert.assertTrue(wasJustCancelled);

        // Give time for the thread to notice the interrupted bit and set the flag
        Thread.sleep(5000);

        // This succeeds when stepping through w/ a debugger, but fails when running
        // the test straight. WHY?
        Assert.assertTrue(interruptedBitSet);

        Assert.assertTrue(future.isDone());
        Assert.assertTrue(future.isCancelled());
    }
}