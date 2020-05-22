JavascriptExecutor js = (JavascriptExecutor) driver;
WebElement element = driver.findElement(By.id("ACC_NO"));

js.executeScript("arguments[0].setAttribute('type', '')",element);

System.out.println(driver.findElement(By.id("ACC_NO")).getAttribute("value"));