//Click on Create Account btn:
driver.findElement(By.id("createAccount")).click();

//Wait till "Cancel" button is showing up. At cases, it may take some time.
WebElement el = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.id("cancelRegister")));
((JavascriptExecutor)driver).executeScript("arguments[0].click()", el);