wait = new WebDriverWait(driver,20); 
driver.manage().window().maximize();

driver.get("https://my.naukri.com/account/createaccount");

wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='userType' and contains(text(),'Professional')]"))).click();

WebElement checkBox = driver.findElement(By.id("term"));

System.out.println(checkBox.isSelected());   // this should print True (Because it is checked)


JavascriptExecutor executor = (JavascriptExecutor)driver;  

Thread.sleep(2000); // for visualization purpose , you can remove it after the execution  

executor.executeScript("arguments[0].click();", checkBox);  // Click it and Uncheck it.

System.out.println(checkBox.isSelected());  // this should print False (Because it is unchecked now)  

Thread.sleep(2000);  //for visualization purpose , you can remove it after the execution  

executor.executeScript("arguments[0].click();", checkBox); //check it again

System.out.println(checkBox.isSelected());   // this should print True (Because it is checked)