try {
    future.get(4, TimeUnit.MINUTES)
} catch(TimeoutException e) {
    //call your method code here, it will be called only if the operation times out
    myMethod();
}