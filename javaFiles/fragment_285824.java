@Override
public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
    if (method.isTestMethod()) {
        WebDriver driver = LocalDriverManager.getDriver();
        if (driver != null) {
            System.out.println("After Test breakdown, quitting driver..." + "Thread id = " + Thread.currentThread().getId());
            driver.quit();
        }
        LocalDriverManager.setWebDriver(null);
    }
}