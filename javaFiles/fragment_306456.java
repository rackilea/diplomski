WebDriverWait wait = new WebDriverWait(driver, 15, 100);
WebElement uploadFileElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("file")));

JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].style.visibility='visible'", uploadFileElement);

uploadFileElement.sendKeys("E:\\Hatha.jpg");