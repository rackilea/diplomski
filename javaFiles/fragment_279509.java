@AfterMethod 
 public void screenShot(ITestResult result){
       if(ITestResult.FAILURE==result.getStatus()){
            List<WebElement> username = driver.findElement(By.locator); // element which displays if user is logged in
            if(!username.isEmpty())
                // steps to logout will go here
            }
       }
  }