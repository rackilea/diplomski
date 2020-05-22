public static ExpectedCondition<List<WebElement>> visibilityOfNElementsLocatedBy(
      final By locator, final int elementsCount) {
    return new ExpectedCondition<List<WebElement>>() {
      @Override
      public List<WebElement> apply(WebDriver driver) {
        List<WebElement> elements = findElements(locator, driver);

        // KEY is here - we are "failing" the expected condition 
        // if there are less than elementsCount elements
        if (elements.size() < elementsCount) {
          return null;
        }

        for(WebElement element : elements){
          if(!element.isDisplayed()){
            return null;
          }
        }
        return elements;
      }

      @Override
      public String toString() {
        return "visibility of N elements located by " + locator;
      }
    };
  }