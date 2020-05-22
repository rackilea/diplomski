public static void moveMouseOver(WebDriver driver, By locator, String...action) {
    List<WebElement> lstElements = driver.findElements(locator);
    for (WebElement webelement : lstElements){
        if (action.length > 0 && action.equalsIgnoreCase("click"))
            (new Actions(driver)).moveToElement(element).click().build().perform();
        else
            (new Actions(driver)).moveToElement(element).build().perform();
}