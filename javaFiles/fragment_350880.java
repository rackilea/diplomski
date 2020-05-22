ExecutorService service = Executors.newFixedThreadPool(1);
    MyCallable myCallable = new MyCallable();
    Future<String> futureResult = service.submit(myCallable);
    String result = null;
    try{
        result = futureResult.get(1000, TimeUnit.MILLISECONDS);
    }catch(TimeoutException e){
        System.out.println("No response after one second");
        futureResult.cancel(true);
    }
    service.shutdown();