ExecutorService pool = Executors.newCachedThreadPool();
for (Runnable r : new Runnable[] {
    new R() { void r() { myMethod1(); }},
    new R() { void r() { myMethod2(); }},
})
  pool.execute(r);
pool.shutdown();
pool.awaitTermination(60, TimeUnit.SECONDS);