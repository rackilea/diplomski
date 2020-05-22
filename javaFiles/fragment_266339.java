ExecutorService pool = Executors.newFixedThreadPool(10);
pool.submit(yourSolutionsRunnable);
pool.submit(yourSolutionsRunnable);
...
// once you've submitted your last job you can do
pool.shutdown();