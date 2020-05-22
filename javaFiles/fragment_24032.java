static final TreeMap<Long, AtomicInteger> counts = new TreeMap<>();

public static final AtomicInteger inc(AtomicInteger i) {
    i.incrementAndGet();
    return i;
}

public static class TimeRunnable implements Runnable {

    private long lastRunAt;

    @Override
    public void run() {
        long now = System.nanoTime();
        long took = TimeUnit.NANOSECONDS.toMillis(now - lastRunAt);
        counts.compute(took, (k, v) -> (v == null) ? new AtomicInteger(1) : inc(v));
        //System.out.println(TimeUnit.NANOSECONDS.toMillis(now - lastRunAt));
        lastRunAt = now;
    }

}

public void test() throws InterruptedException {
    System.out.println("Hello");
    ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
    exec.scheduleAtFixedRate(new TimeRunnable(), 0, 10, TimeUnit.MILLISECONDS);
    // Wait a bit.
    Thread.sleep(10000);
    // Shut down.
    exec.shutdown();
    while (!exec.awaitTermination(60, TimeUnit.SECONDS)) {
        System.out.println("Waiting");
    }
    System.out.println("counts - " + counts);
}