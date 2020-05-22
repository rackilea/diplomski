WebDriver driver = new FirefoxDriver();
driver.get("http://stackoverflow.com");
WebElement element = driver.findElement(By.linkText("Stack Overflow"));
// set the target _blank on the link
((JavascriptExecutor)driver).executeScript("arguments[0].target='_blank';", element);
// click the link
element.click();
// set the context to the new window
driver.switchTo().window(driver.getWindowHandles().toArray()[1]);