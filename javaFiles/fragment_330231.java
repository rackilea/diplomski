// Initiate you thread pool and make sure it is unique
    ExecutorService service = Executors.newFixedThreadPool(1);

    ...
    // In your web method:
    Future<?> futureResult = service.submit(new Runnable()/or new Callable());
    // Using callable, you will get a Typed Future

    Object result = futureResult.get();// If you need to wait for the result of the runnable/callable.
    ...