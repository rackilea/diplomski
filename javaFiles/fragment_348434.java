new FluentWait<JavascriptExecutor>(executor) {
  protected RuntimeException timeoutException(
      String message, Throwable lastException) {
    Assert.fail("name was never set");
  }
}.withTimeout(10, SECONDS)
.until(new Predicate<JavascriptExecutor>() {
  public boolean apply(JavascriptExecutor e) {
    return (Boolean)executor.executeScript("return ('Hello' === getName());");
  }
});