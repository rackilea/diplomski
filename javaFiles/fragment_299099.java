@Rule
public TestRule watcher = new TestWatcher() {
    @Override
    public void finished(Description description) {
        driver.quit();
    }

    @Override
    public void failed(Throwable e, Description description) {
        try {
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            String filePathRoot = "C:\\_Jenkins\\workspace\\" + jenkinsJobName + "\\target\\surefire-reports\\";
            String fullFilePath = filePathRoot + description.getClassName() + "\\" + description.getMethodName() + ".jpg";

            FileUtils.copyFile(screenshot, new File(fullFilePath));
        } catch(Exception ex) {
            System.out.println(ex.toString());
            System.out.println(ex.getMessage());
        }

        driver.quit();
    }
};