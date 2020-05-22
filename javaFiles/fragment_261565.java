@Override
    public synchronized void onTestFailure(ITestResult result) {
        System.out.println("!!!!!!!!!!!!!!!!!!!! Test Failed !!!!!!!!!!!!!!!!!!!!");

        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver"); // accessing driver here
        String feature = getClass().getName();
        String screenShot;
        try {
            screenShot = CaptureScreenshot.captureScreen(driver, CaptureScreenshot.generateFileName(feature));
            test.addScreenCaptureFromPath(screenShotPath);  // I am assuming that the "screenShot" is fully qualified path with extension e.g "C:\Users\12345\Desktop\sfgfdh.PNG"
        } catch (IOException ex) {    
            LogManager.logger.log(Level.INFO, "Exception: " + ex.getMessage());
        }

    }