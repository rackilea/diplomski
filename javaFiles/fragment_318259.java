public class onFailure extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {

    File scrFile = ((TakesScreenshot)driver.getScreenshotAs(OutputType.FILE)); 
    FileUtils.copyFile(scrFile, new File("C:\\Screenshots\\Regression\\"+nameVar+"_"+envVar+".png")); 
    }

}