ExecutorService exectutorService = Executors.newCachedThreadPool();
 List<Callable<Object>> callables = Arrays.asList(
            (Callable(Object) new Check1Callable(),
            (Callable(Object) new Check2Callable(),
            (Callable(Object) new Check3Callable());

 List<Future<Object>> futures = new ArrayList<>();

 try {
     futures = executorService.invokeAll(callables,maxWaitTime, TimeUnit.SECONDS);
 } catch (Exception e) {
 }

 for (Future thisFuture : futures) {
    try {
        if (thisFuture.isDone() && !thisFuture.isCancelled()) {
           <accept the future's result>
        }
    } catch (Exception e) {
    }
 }