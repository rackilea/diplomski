@Override
    public void executeAssert(IAssert a) {
    try {
        a.doAssert();
    } catch (AssertionError ex) {
        onAssertFailure(a, ex);
        takeScreenshot();
        m_errors.put(ex, a);
    }
    }

    private void takeScreenshot() {
    WebDriver augmentedDriver = new Augmenter().augment(driver);
    try {
        if (driver != null
            && ((RemoteWebDriver) driver).getSessionId() != null) {
        File scrFile = ((TakesScreenshot) augmentedDriver)
            .getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(("./test-output/archive/"
            + "screenshots/" + "_" + ".png")));
        }       
    } catch (Exception e) {
        e.printStackTrace();
    }
    }