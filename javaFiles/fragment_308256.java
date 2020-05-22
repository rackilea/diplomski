public void waitAndClickElement(By locator)
{
    try
    {
        this.wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    catch (TimeoutException e)
    {
        System.out.println("Count not click element <" + locator.toString() + ">");
    }
}