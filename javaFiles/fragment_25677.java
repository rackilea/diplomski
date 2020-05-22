public class CustomListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        super.onTestFailure(iTestResult);
        TestCase tCase = (TestCase) iTestResult.getParameters()[0];
        iTestResult.setAttribute("failed_case", tCase);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        super.onTestSuccess(iTestResult);
        TestCase tCase = (TestCase) iTestResult.getParameters()[0];
        iTestResult.setAttribute("passed_case", tCase);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        super.onTestSkipped(iTestResult);
        TestCase tCase = (TestCase) iTestResult.getParameters()[0];
        iTestResult.setAttribute("skipped_case", tCase);
    }
  }