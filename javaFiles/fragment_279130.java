@AfterMethod
public void tearDown(ITestResult result) {
   if (result.getStatus() == ITestResult.FAILURE) {
      //your screenshooting code goes here
   }        
}