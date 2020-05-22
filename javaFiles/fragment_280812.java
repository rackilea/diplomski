WebDriverWait wait = new WebDriverWait(driver, 10);
while (driver.findElements(By.cssSelector(".bootstrap-switch-handle-off")).size() > 0) {
    WebElement toggle =
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bootstrap-switch-handle-off")));
    toggle.click();
    //wait.until(ExpectedConditions.invisibilityOf(toggle));
    wait.until(d -> {
        try {
            return !toggle.isDisplayed();
        } catch (StaleElementReferenceException ignored) {
           return true;
        }
    });
}