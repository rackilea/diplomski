Future myFuture = threadPoolTaskExecutor.submit(myCallable);
try {
    myResult = myFuture.get(5l,TimeUnit.SECONDS);
} catch(TimeoutException e) {
    // Timeout-Related stuff here
}