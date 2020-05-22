CompletableFuture<T> requestWrapper = CompletableFuture.supplyAsync(() -> {
  return restTemplate.postForEntity(/* Whatever arguments you need to pass */);
});

try {
  return requestWrapper.get(5000, TimeUnit.MILLISECONDS);
} catch (TimeoutException e) {
  requestWrapper.cancel(true);
  throw new TimeoutException("Endpoint took too long to respond, TimeoutException is triggered");
} catch (ExecutionException e) {
  throw e.getCause();
}