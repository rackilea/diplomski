class FooWithUnlimitedRetry implements Foo {
  private final Foo origin;
  @Override
  @RetryOnFailure(attempts = 10000)
  public void method() {
    this.origin.method();
  }
}