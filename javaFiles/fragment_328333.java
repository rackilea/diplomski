public boolean isElementPresent(By locatorKey) {
    try {
        driver.findElement(locatorKey);
        return true;
    } catch (org.openqa.selenium.NoSuchElementException e) {
        return false;
    }
}

public boolean isElementVisible(String cssLocator){
    return driver.findElement(By.cssSelector(cssLocator)).isDisplayed();
}