ExecutorService pool = Executors.newCachedThreadPool();
pool.invokeAll(Collections.nCopies(10, () -> {
    LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(
            ThreadLocalRandom.current().nextInt(50, 300)));
    final String s = "Completed on "+Thread.currentThread().getName();
    System.out.println(s);
    return s;
}));
pool.shutdown();