public By getElem1Locator() {
    return By.cssSelector(....);
}
public By getElem2Locator() {
    return By.tagName(....);
}

...

    WebElement elem2 = wait.until(new ExpectedCondition<WebElement>() {
        public WebElement apply(WebDriver driver) {
            try {
                return driver.findElement(getElem1Locator()).findElement(getElem2Locator());
        } catch (NoSuchElementException e) {
            return null;
        }
    });

...