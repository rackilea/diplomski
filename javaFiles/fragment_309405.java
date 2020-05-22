public static ExpectedCondition<WebElement> waitForElementToContainText(final String cssSelector, final String visibleText) {
    return new ExpectedCondition<WebElement>() {
        @Override
        public WebElement apply(WebDriver webDriver) {
            WebElement anElement = webDriver.findElement(By.cssSelector(cssSelector);
            if (anElement.getText().contains(visibleText)) {
                return anElement; // Condition passed
            }
            return null; // Condition failed
        }

        public String toString() {
            return "first occurance of text '" + visibleText + "' in element " + cssSelector;
        }
    };
}