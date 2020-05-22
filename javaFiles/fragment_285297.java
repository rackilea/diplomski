public static ExpectedCondition<WebElement> isDisplayed(final By locator) {
    return new ExpectedCondition<WebElement>() {

        public WebElement apply(WebDriver driver) {
            WebElement element = webDriver.findElement(locator); 
            if (element.isDisplayed()) {
                return element;
            }
        }
    };
}