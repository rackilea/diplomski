ExecutorService pool = Executors.newFixedThreadPool(10);
for (int k = i; k < p; k++) {
    Runnable r = new FooConfigCheck(finData.get(k));
    pool.submit(r);
}
pool.shutdown();
while (!pool.awaitTermination(1000, TimeUnit.SECONDS)) ;