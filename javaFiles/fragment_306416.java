Actions action = new Actions(driver);
WebElement list = driver.findElement(By.xpath("//*[@id=\"gridview-1032\"]")); 
action.moveToElement(list);
JavascriptExecutor js = (JavascriptExecutor) driver;

 // Now I need to scroll down till find my desire project in the list.

 WebElement Project = driver.findElement(By.xpath("//*[text()= '"+ projectName +"']"));                 
js.executeScript("arguments[0].click();",Project);