try {
    future.get();
} catch (ExecutionException e) {
    Throwable exceptionInFuture = e.getCause();
    //throw, log or whatever is appropriate
}