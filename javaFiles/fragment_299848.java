ListenableFuture<Integer> nullFuture = executor.submit(() -> null);
ListenableFuture<Integer> exceptionFuture = executor.submit(() -> {
    throw new RuntimeException();
});

// Replace first argument with exceptionFuture to get another result
ListenableFuture<Integer> transformer = Futures.transformAsync(nullFuture, i -> {
    System.out.println(i);
    return Futures.immediateCheckedFuture(1);
}, executor);

Futures.addCallback(transformer, new FutureCallback<Integer>() {
    @Override
    public void onSuccess(Integer result) {
        System.out.println(result);
  }

    @Override
    public void onFailure(Throwable t) {
        System.out.println(t);
  }
});