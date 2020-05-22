targetElement = driver.findElement(By.xpath("your xpath"));
JavascriptExecutor js = ((JavascriptExecutor) driver);
// This:
js.executeScript("arguments[0].scrollIntoView(true);", targetElement);
targetElement.click();
// Or maybe even just:
js.executeScript("arguments[0].click();", targetElement);