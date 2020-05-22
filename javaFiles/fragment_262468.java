public boolean isElementPresentByLocator(By locator)
{
    try
    {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(locator));
        System.out.println("Element is visible: " + locator.toString());
        return true;
    }
    catch (TimeoutException e)
    {
        System.out.println("Unable to locate the element: " + locator.toString() + ", Exception: " + e.toString());
        return false;
    }
}