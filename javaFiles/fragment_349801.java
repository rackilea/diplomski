public static ExpectedCondition<Boolean> textToBePresentInElementLocated(
      final By locator, final String text) {

    return new ExpectedCondition<Boolean>() {
      @Override
      public Boolean apply(WebDriver driver) {
        try {
          String elementText = findElement(locator, driver).getText();
          return elementText.contains(text);
        } catch (StaleElementReferenceException e) {
          return null;
        }
      }

      @Override
      public String toString() {
        return String.format("text ('%s') to be present in element found by %s",
            text, locator);
      }
    };
  }