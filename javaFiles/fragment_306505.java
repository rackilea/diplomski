WebElement elementOldPage = driver.findElement(By.id("yourid"));

... do login etc ...

WebDriverWait wait = new WebDriverWait(driver, 10);
wait.until(ExpectedConditions.stalenessOf(elementOldPage));

WebElement elementNewPage = driver.findElement(By.id("yourid"));