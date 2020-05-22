public class MyNewListener implements IConfigurationListener2, ITestListener {

  private final ThreadLocal<ITestResult> currentTest = new ThreadLocal<>();

  @Override
  public void onTestStart(ITestResult result) {
    System.out.println("Starting test method:" + result.getMethod().getMethodName());
    currentTest.set(result);
  }

  @Override
  public void onConfigurationFailure(ITestResult result) {
    System.out.println("Failed to run " + result.getMethod().getMethodName()
            + " for the test method:" + currentTest.get().getMethod().getMethodName());
  }
}