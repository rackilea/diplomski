/**
 * Method returns WebElement by Xpath.
 * 
 * @param String xpathExpression
 * @param WebDriver driver
 * @return WebElement
 */
public WebElement getElementByXpath(String xpathExpression, WebDriver driver){
    return driver.findElement(By.xpath(xpathExpression));
}

/**
 * Method returns WebElement by ID.
 * 
 * @param String id
 * @param WebDriver driver
 * @return WebElement
 */
public WebElement getElementByID(String id, WebDriver driver){
    return driver.findElement(By.id(id));
}