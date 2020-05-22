@Inject public YourCallerConsumer(Provider<RetryServiceCaller> callerProvider) {
  this.callerProvider = callerProvider;
}

public void doAction() {
  RetryServiceCaller newCaller = callerProvider.get();
  // interact with caller
}