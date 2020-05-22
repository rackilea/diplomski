private static final String JS_JQUERY_DEFINED = "return typeof jQuery != 'undefined';";
private static final String JS_PRIMEFACES_DEFINED = "return typeof PrimeFaces != 'undefined';";
private static final String JS_JQUERY_ACTIVE = "return jQuery.active != 0;";
private static final String JS_PRIMEFACES_QUEUE_NOT_EMPTY = "return !PrimeFaces.ajax.Queue.isEmpty();";

private static final int TIME_OUT_SECONDS=10;
private static final int POLLING_MILLISECONDS=500;

private void waitForJQueryAndPrimeFaces() {
   new FluentWait(driver).withTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
      .pollingEvery(POLLING_MILLISECONDS, TimeUnit.MILLISECONDS)
      .until(new Function < WebDriver, Boolean >() {
         @Override
         public Boolean apply(WebDriver input) {
            boolean ajax = false;
            boolean jQueryDefined = executeBooleanJavascript(input, JS_JQUERY_DEFINED);
            boolean primeFacesDefined = executeBooleanJavascript(input, JS_PRIMEFACES_DEFINED);

            if (jQueryDefined) {
               // jQuery is still active
               ajax |= executeBooleanJavascript(input, JS_JQUERY_ACTIVE);
            }
            if (primeFacesDefined) {
               // PrimeFaces queue isn't empty
               ajax |= executeBooleanJavascript(input, JS_PRIMEFACES_QUEUE_NOT_EMPTY);
            }

            // continue if all ajax request are processed
            return !ajax;
         }
      });
}

private boolean executeBooleanJavascript(WebDriver input, String javascript) {
   return (Boolean) ((JavascriptExecutor) input).executeScript(javascript);
}