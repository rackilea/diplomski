public class ExtentTestNGReportBuilder {

    private ThreadLocal<ExtentTest> parentTest;
    private ThreadLocal<ExtentTest> test;

    @BeforeClass
    public synchronized void beforeClass() {
        ExtentTest parent = ExtentTestManager.createTest(getClass().getName());
        parentTest.set(parent);
    }

    @BeforeMethod
    public synchronized void beforeMethod(Method method) {
        ExtentTest child = parentTest.get().createNode(method.getName());
        test.set(child);
    }

    @AfterMethod
    public synchronized void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE)
            test.get().fail(result.getThrowable());
        else if (result.getStatus() == ITestResult.SKIP)
            test.get().skip(result.getThrowable());
        else
            test.get().pass("Test passed");

        ExtentManager.getExtent().flush();
    }

}