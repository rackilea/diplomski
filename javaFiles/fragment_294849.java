WebElement e1 = driver.findElement(By.linkText("Admin"));
WebElement e2 = driver.findElement(By.xpath(("Element1_xpath"));
WebElement e3 = driver.findElement(By.xpath("Element2_xpath"));

Actions action = new Actions(driver);
action.moveToElement(e1).clickAndHold().build().perform();      
action.moveToElement(e2).clickAndHold().build().perform();
action.moveToElement(e3).click().build().perform();
Thread.sleep(2000);