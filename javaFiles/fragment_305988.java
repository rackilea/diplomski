class JobUT extends Job {
  @Override
  public Void call() throws Exception {
    Void result = super.call();
    // Report error if wrong return result
  }
}