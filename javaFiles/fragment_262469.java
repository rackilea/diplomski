public boolean isElementPresentByWebElement(WebElement element)
{
    try
    {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(element));
        System.out.println("Element is visible: " + element.toString());
        return true;
    }
    catch (TimeoutException e)
    {
        System.out.println("Unable to locate the element: " + element.toString() + ", Exception: " + e.toString());
        return false;
    }
}