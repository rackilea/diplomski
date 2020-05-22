static final Object LOCK1 = new Object();
static final Object LOCK2 = new Object();
static int i1 = 0;
static int i2 = 0;
static final AtomicInteger ai1 = new AtomicInteger();
static final AtomicInteger ai2 = new AtomicInteger();

public static void main(String... args) throws  ExecutionException, InterruptedException {
    for(int i=0;i<5;i++) {
        testSyncInt();
        testAtomicInt();
    }
}

private static void testSyncInt() throws ExecutionException, InterruptedException {
    long start = System.nanoTime();
    final int runs = 1000000;
    ExecutorService es = Executors.newFixedThreadPool(2);
    List<Future<Void>> futures = new ArrayList<>();
    for(int t=0;t<8;t++) {
        futures.add(es.submit(new Callable<Void>() {
            public Void call() throws Exception {
                for (int i = 0; i < runs; i += 2) {
                    synchronized (LOCK1) {
                        i1++;
                    }
                    synchronized (LOCK2) {
                        i2++;
                    }
                }
                return null;
            }
        }));
    }
    for (Future<Void> future : futures) {
        future.get();
    }
    es.shutdown();
    long time = System.nanoTime() - start;
    System.out.printf("sync + incr: Each increment took an average of %.1f ns%n", (double) time/runs/2);
}

private static void testAtomicInt() throws ExecutionException, InterruptedException {
    long start = System.nanoTime();
    final int runs = 1000000;
    ExecutorService es = Executors.newFixedThreadPool(2);
    List<Future<Void>> futures = new ArrayList<>();
    for(int t=0;t<8;t++) {
        futures.add(es.submit(new Callable<Void>() {
            public Void call() throws Exception {
                for (int i = 0; i < runs; i += 2) {
                    ai1.incrementAndGet();
                    ai2.incrementAndGet();
                }
                return null;
            }
        }));
    }
    for (Future<Void> future : futures) {
        future.get();
    }
    es.shutdown();
    long time = System.nanoTime() - start;
    System.out.printf("incrementAndGet: Each increment took an average of %.1f ns%n", (double) time/runs/2);
}