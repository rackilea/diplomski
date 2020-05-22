//submit is a button.
//driver is a WebDriver.
//uppderTimeoutLimit is an int, 10000
WebDriverWait wait = new WebDriverWait(driver, upperTimeoutLimit);
WebElement sizeEle = driver.findElement(By.cssSelector(selector));
String beforeCount = sizeEle.getText();
submit.click();
System.out.println("about to wait until change");
wait.until(ExpectedConditions.not(ExpectedConditions.textMatches(
        By.cssSelector(selector),
        Pattern.compile(beforeCount))));