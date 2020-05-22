public static void OpenTab(this IWebDriver driver, string url)
{
    var windowHandles = driver.WindowHandles;
    var script = string.Format("window.open('{0}', '_blank');", url);
    ((IJavaScriptExecutor)driver).ExecuteScript(script);
    var newWindowHandles = driver.WindowHandles;
    var openedWindowHandle = newWindowHandles.Except(windowHandles).Single();
    driver.SwitchTo().Window(openedWindowHandle);
}