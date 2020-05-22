@AfterMethod(alwaysRun = true)
    public void closeDriverInstance() {
        try {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(
String.format("c:\\SeleniumScreenshots\\%s.jpg", count)));
            driver.close();
        } catch (Exception e) {
            log.info(" oops, it seems that driver instance have been already closed.");
        }
    }