@Override
public void onTestStart(ITestResult result) {

    String valueFromInterface;

    Method method = result.getMethod().getMethod();

    if (method.isAnnotationPresent(DisplayName.class)) {
        DisplayName displayName = method.getAnnotation(DisplayName.class);
        if (displayName != null) {
          valueFromInterface = displayName.value();
        }
    }

    ExtentTestManager.startTest(iTestResult.getMethod().getDescription(), valueFromInterface);
}