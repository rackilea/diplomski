WebDriverWait wait = new WebDriverWait(webDriver, 10);

WebElement linkList = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("oList"))); 
linkList.click();

WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Algeria"))); 
link.click();