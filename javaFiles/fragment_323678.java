ExecutorService pool = Executors.newFixedThreadPool(poolSize);
FutureTask<String> future = new FutureTask(new Callable() {
    public String call() {
        ...
    return res;
});
executor.execute(future);

String res = future.get();