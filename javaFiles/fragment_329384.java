WebDriver driver = new FirefoxDriver();
driver.get("http://stackoverflow.com");
// open a new window
((JavascriptExecutor)driver).executeScript("window.open(window.location.href, '_blank');");
// set the context to the new window
driver.switchTo().window(driver.getWindowHandles().toArray()[1]);
// click the link
driver.findElement(By.linkText("Stack Overflow")).click();