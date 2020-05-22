public class MyCustomConditions {

  public static ExpectedCondition<Boolean> myCustomCondition() {
    return new ExpectedCondition<Boolean>() {
      @Override
      public Boolean apply(WebDriver driver) {
        return (Boolean) ((JavascriptExecutor) driver)
          .executeScript("return document.getElementById('video_html5').seeking === 'string_value' || ... ");
      }
    };
  }
}