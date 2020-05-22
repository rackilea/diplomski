static final Object LOCK1 = new Object();
static final Object LOCK2 = new Object();
static int i1 = 0;
static int i2 = 0;
static final AtomicInteger ai1 = new AtomicInteger();
static final AtomicInteger ai2 = new AtomicInteger();

public static void main(String... args) throws IOException {
    for(int i=0;i<5;i++) {
        testSyncInt();
        testAtomicInt();
    }
}

private static void testSyncInt() {
    long start = System.nanoTime();
    int runs = 10000000;
    for(int i=0;i< runs;i+=2) {
        synchronized (LOCK1) {
            i1++;
        }
        synchronized (LOCK2) {
            i2++;
        }
    }
    long time = System.nanoTime() - start;
    System.out.printf("sync + incr: Each increment took an average of %.1f ns%n", (double) time/runs);
}

private static void testAtomicInt() {
    long start = System.nanoTime();
    int runs = 10000000;
    for(int i=0;i< runs;i+=2) {
        ai1.incrementAndGet();
        ai2.incrementAndGet();
    }
    long time = System.nanoTime() - start;
    System.out.printf("incrementAndGet: Each increment took an average of %.1f ns%n", (double) time/runs);
}