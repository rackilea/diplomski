public void scrollAndClick(By by)
{
   WebElement element = driver.findElement(by);
   int elementPosition = element.getLocation().getY();
   String js = String.format("window.scroll(0, %s)", elementPosition);
   ((JavascriptExecutor)driver).executeScript(js);
   element.click();
}