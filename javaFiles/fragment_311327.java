protected WebElement waitForElementVisible(By by) {
    WebDriverWait wait = new WebDriverWait(driver,6);
    WebElement element = null;

    try {
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    } catch (TimeoutException e) {
        //method logging an error
        error("Timeout : element " + by.toString() + " is not visible");
    }
    return element;
}