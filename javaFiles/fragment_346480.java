interface Foo {
  void method();
}
class FooWithRetry implements Foo {
  private final Foo origin;
  @Override
  @RetryOnFailure(attempts = Constant.RETRY_ATTEMPTS)
  public void method() {
    this.origin.method();
  }
}