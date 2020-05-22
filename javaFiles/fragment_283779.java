driver.findElement(By.xpath("//*[@id='adduser']/div/form/div[2]/div/div/label")).click(); Thread.sleep(1000);
wait.until(ExpectedConditions.alertIsPresent());

Alert alert = driver.switchTo().alert();
alertText = alert.getText();
alert.accept();