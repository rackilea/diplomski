@AfterReturning(pointcut = "execution(* xxxxx*(..))", returning = "paramOut")
public void logger(final JoinPoint jp, Object paramOut){
     Event event = (Event) paramOut;

     ExecutorService executor = Executors.newSingleThreadExecutor();

     Future<Void> future = executor.submit(new Callable<Void>() {
         public Void call() throws Exception {
            myService.save(event);
            return null;
        }
    });

    try
    {
        future.get(30, TimeUnit.SECONDS);
    }
    catch(InterruptedException | ExecutionException | TimeoutException e){
       //do something or log it
    } finally {
       future.cancel(true);
    }

 }