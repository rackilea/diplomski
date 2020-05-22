@Test
public void test() throws Exception {
    int before = Thread.activeCount();
    int core = 10;
    int max = 50;
    int queueSize = 100;
    ThreadPoolExecutor tpe =
            new ThreadPoolExecutor(core, max, 1L, TimeUnit.SECONDS,
                    new LinkedBlockingQueue<Runnable>(queueSize),
                    new ThreadPoolExecutor.CallerRunsPolicy());
    tpe.allowCoreThreadTimeOut(false);
    assertEquals(0, tpe.getActiveCount());
    // if we start 1 more than can go into core or queue, poolSize goes to 0
    int startN = core + queueSize + 1;
    // if we only start jobs the core can take care of, then it won't go to 0
    // int startN = core + queueSize;
    for (int i = 0; i < startN; i++) {
        tpe.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    while (true) {
        System.out.println("active = " + tpe.getActiveCount() + ", poolSize = " + tpe.getPoolSize()
                + ", largest = " + tpe.getLargestPoolSize() + ", threads = " + (Thread.activeCount() - before));
        Thread.sleep(1000);
    }
}