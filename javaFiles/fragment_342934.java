driver.get("");

 try {

     (new WebDriverWait(driver, 1)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("something we know should exist if page load");

 } catch (Exception ex) {

     //Alternative to javaScript is to use Actions Class and send ESC key to stop execution
     //Actions actions = new Actions(driver);
     //actions.sendKeys(Keys.ESCAPE);
     ((JavascriptExecutor) driver).executeScript("window.stop;");
      driver.quit();
 }