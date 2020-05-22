...
driver.findElement(By.id("login-ddl-link")).click();
Thread.sleep(2000);
driver.switchTo().frame("iframe-accounts");
WebElement myEmail = driver.findElement(By.id("inputEmail"));
myEmail.sendKeys("tes123");
...