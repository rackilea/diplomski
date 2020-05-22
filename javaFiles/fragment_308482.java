try {
     CompletableFuture<Void> future = CompletableFuture.runAsync(processRunnable);
    future.get(1000, TimeUnit.MILLISECONDS);
}
catch{
case texc : TimeoutException => println("Timeout is reached.")
case exc  : Exception => println(exc.getmessage)
}