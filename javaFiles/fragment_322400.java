public class WebDriverListener implements IInvokedMethodListener {

    public static int testNumber = 0;

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult){
        try 
        {
            LocalTestManager.initializeSettings();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        if (method.toString().toLowerCase().contains("beforescenario")) {
            WebDriver driver = null;
            try {
                driver = LocalDriverFactory.createInstance(TestSettings.getBrowser(), TestSettings.getIsHeadless());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            LocalDriverManager.setDriver(driver);
            testNumber ++;
            System.out.println("Now executing test number: " + testNumber);
            LocalTestManager.setTestName(method.getTestMethod().getMethodName());
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        WebDriver driver = LocalDriverManager.getDriver();
            if(method.toString().toLowerCase().contains("afterscenario")){
                try {
                    if (driver != null) {
                        driver.quit();
                    }
                } catch (Exception e) {
                    driver.quit();
                    throw e;
                }
                finally {
                    driver.quit();
                }
            }
    }
}