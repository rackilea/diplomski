Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()
//  .retryIfExceptionOfType(Exception.class)
    .withStopStrategy(MoreStopStrategies.liveStopAfterAttempt(retries))
    .withWaitStrategy(MoreWaitStrategies.liveExponentialWait(TimeUnit.MILLISECONDS, retrySleep, TimeUnit.MILLISECONDS))
    .build();

void doStuff() {
  try {
    retryer.call(() -> {
        doRealStuff();
      });
  } catch (RetryException e) {
    throw new RuntimeException("Call never succeeded", e);
  } catch (ExecutionException e) {
    Throwables.propagateIfPossible(e.getCause(), ArithmeticException.class);
    throw new RuntimeException("Unexpected", e);
  }
}