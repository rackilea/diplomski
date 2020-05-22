@Rule
public TestWatcher screenshotOnFailure = new TestWatcher() {
    @Override
    protected void failed(Throwable e, Description description) {
        makeScreenshotOnFailure();
    }

    @Attachment("Screenshot on failure")
    public byte[] makeScreenshotOnFailure() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
};