wait.until(ExpectedConditions.visibilityOfElementLocated(buttonBy);

WebElement button=driver.findElement(buttonBy);

JavascriptExecutor executor = (JavascriptExecutor)driver;

executor.executeScript("arguments[0].click();", button);