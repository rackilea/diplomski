public static boolean isElementDisplayed(WebElement element) {
    try {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    } catch (org.openqa.selenium.NoSuchElementException
            | org.openqa.selenium.StaleElementReferenceException
            | org.openqa.selenium.TimeoutException e) {
        return false;
    }
}