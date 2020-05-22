void onTestStart(ITestResult result) {
  section annotation = result.getTestClass().getRealClass().getAnnotation(section.class);
  if (annotation != null) {
    // do something with annotation.Name()
  }
}