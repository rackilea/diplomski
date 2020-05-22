// First, this routine is in a library somewhere
public void waitForTest(JavascriptExecutor executor, String testId) {
  new FluentWait<JavascriptExecutor>(executor) {
    protected RuntimeException timeoutException(
        String message, Throwable lastException) {
      Assert.fail(testId + " did not finish async calls");
    }
  }.withTimeout(10, SECONDS)
  .until(new Predicate<JavascriptExecutor>() {
    public boolean apply(JavascriptExecutor e) {
      return (Boolean)executor.executeScript(
          "_isTestDone_('" + testId + "');");
    }
  });
}

// Inside an actual test:
@Test public void serverPingTest() {
  // Do stuff to grab my WebDriver instance
  // Do this before any interaction with the app
  driver.executeScript("_setJunitTestid_('MainAppTest.serverPingTest');");
  // Do other stuff including things that fire off what would be async calls
  // but now call stuff in my testing library instead.
  // ...
  // Now I need to wait for all the async stuff to finish:
  waitForTest(driver, "MainAppTest.serverPingTest");
  // Now query stuff about the app, assert things if needed
}