WebElement element = driver.findElement(by);
element.click();
driver.switchTo().defaultContent(); // or driver.switchTo().parentFrame();
new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("xyz")));
// wait for stalenessOf previous element (visibility of next desired element preferred)
new WebDriverWait(driver, 4, 100).until(ExpectedConditions.stalenessOf(element));
// or wait for visibility of next desired element (preferred approach)
new WebDriverWait(driver, 4, 100).until(ExpectedConditions.visibilityOfElementLocated(next_desired_element));