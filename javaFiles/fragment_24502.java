ExecutorService executor = Executors.newSingleThreadExecutor();
Future future = executor.submit(new ImportantDataProcessing());
try {
    future.get(100, TimeUnit.SECONDS);
}
catch (InterruptedException e) {
    e.printStackTrace();
}
catch (ExecutionException e) {
    e.printStackTrace();
}
catch (TimeoutException e) {
    // the timeout to handle but other exceptions should be handled :)  
    e.printStackTrace();
}
executor.shutdown();