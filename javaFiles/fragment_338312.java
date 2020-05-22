/**
 * Wait for element to appear on the webpage
 * @param driver
 * @param locatorObject
 */
public void waitForElementToBeVisible(WebDriver driver, By locatorObject) {
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(locatorObject));
}


/**
 * Waits for element to become interactive/clickable
 * @param driver
 * @param locatorObject
 */
public void waitForElementToBeClickable(WebDriver driver, By locatorObject) {
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.elementToBeClickable(locatorObject));
}