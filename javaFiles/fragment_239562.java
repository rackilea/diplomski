WebDriver driver = new FirefoxDriver();
WebElement frame1 = driver.findElement(By.xpath("//iframe[@class='Am Al editable']"));
driver.switchTo().frame(frame1);
WebElement editable = driver.switchTo().activeElement();
String mailBody = "Hi," + '\n' + "I'm Ripon from Dhaka, Bangladesh.";
editable.sendKeys(mailBody);
driver.switchTo().defaultContent();