@Override
public void afterTestMethod(TestContext testContext) throws Exception {
    if (testContext.getTestException() == null) {
        return;
    }

    final Config config = testContext.getApplicationContext().getBean(Config.class);
    File screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
    String testName = toLowerUnderscore(testContext.getTestClass().getSimpleName());
    String methodName = toLowerUnderscore(testContext.getTestMethod().getName());

    FileUtils.copyFile(screenshot, new File( config.getScreenshotsPath() + testName + "_" + methodName + "_" + screenshot.getName()));
}