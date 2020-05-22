public class MyNewListener implements IConfigurationListener2, ITestListener {

  private final ThreadLocal<ITestResult> failedConfiguration = new ThreadLocal<>();

  @Override
  public void onTestStart(ITestResult result) {
    System.out.println("Starting test method:" + result.getMethod().getMethodName());
  }

  @Override
  public void onConfigurationFailure(ITestResult result) {
    failedConfiguration.set(result);
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    System.out.println("Failed to run " + failedConfiguration.get().getMethod().getMethodName()
            + " for the test method:" + result.getMethod().getMethodName());
  }
}