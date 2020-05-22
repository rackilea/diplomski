ExecutorService executor = Executors.newFixedThreadPool(3);
while (cond) {
    Future<V> aFuture = executor.submit(new MyCallable(param1));
    Future<V> bFuture = executor.submit(new MyCallable(param2));
    Future<V> cFuture = executor.submit(new MyCallable(param3));

    // this will block until all calculations are finished:
    a = aFuture.get();
    b = bFuture.get();
    c = cFuture.get();

   // do something with a/b/c, e.g. calc new params.
}