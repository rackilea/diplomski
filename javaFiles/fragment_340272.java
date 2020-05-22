public static int scrollDown()
{
    JavascriptExecutor js = ((JavascriptExecutor) driver);
    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

    return (int) (long) js.executeScript("return document.body.scrollHeight;");
}

public static boolean isElementPresent(By locator)
{
    return !driver.findElements(locator).isEmpty();
}