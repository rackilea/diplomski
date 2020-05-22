//Click on Create Account btn:
driver.findElement(By.id("createAccount")).click();

//Now wait for invisibility of progress bar first 
myWaitVar.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page_loader")));

//Now wait till "Cancel" button is showing up. At cases, it may take some time.
WebElement el = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.id("cancelRegister")));
el.click();