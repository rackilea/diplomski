WebElement sourceTitle = driver.findElement(By.name("sourceTitle"));

WebElement small = driver.findElement(By.cssSelector("li#nameExampleSection label + small"));

sourceTitle.sendKeys("ABC Premium News (Australia)"); 

Thread.sleep(5000);

Actions actions = new Actions(driver);

actions.click(small).perform();