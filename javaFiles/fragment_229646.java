public boolean waitForJSandJQueryToLoad() {

    WebDriverWait wait = new WebDriverWait(driver, 30);

    // wait for jQuery to load
    ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
      @Override
      public Boolean apply(WebDriver driver) {
        try {
          return ((Long)((JavascriptExecutor)getDriver()).executeScript("return jQuery.active") == 0);
        }
        catch (Exception e) {
          // no jQuery present
          return true;
        }
      }
    };

    // wait for Javascript to load
    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
      @Override
      public Boolean apply(WebDriver driver) {
        return ((JavascriptExecutor)getDriver()).executeScript("return document.readyState")
        .toString().equals("complete");
      }
    };

  return wait.until(jQueryLoad) && wait.until(jsLoad);
}