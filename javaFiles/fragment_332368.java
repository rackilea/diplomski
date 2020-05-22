public void click(WebDriver driver, WebElement element, boolean withJS){
    if (withJS){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
    } else {
        element.click();
    }
}