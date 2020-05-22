WebDriverWait wait = new WebDriverWait(driver, 10);
WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.CFApplyButtonConatiner"))));
List<WebElement> elementsList = driver.findElements(By.cssSelector("div.CFApplyButtonConatiner > button");
for(WebElement  ele: elementsList) {
    if(ele.isDisplayed()) {
        ele.click();
    }
}