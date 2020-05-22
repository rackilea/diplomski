ExecutorService es = Executors.newCachedThreadPool();
// pool is reusable

List<Callable<Void>> callables = new ArrayList<Callable<Void>>();
for(int i=0;i<sth;i++) callables.add(new MyCallable(i));
for(Future<Void> futures : es.invokeAll(callables))
    futures.get();