@Rule
  public TestRule testWatcher = new TestWatcher() {
    @Override
    protected void failed(Throwable e, Description description) {
      File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      String scrFilename = "Screenshot_"+ DateUtils.now().getTime()+".png";
      File outputFile = new File(screenshotPath, scrFilename);
      try {
        LOGGER.info("Saving screenshot of failed test...");
        FileUtils.copyFile(scrFile, outputFile);
      } catch (IOException ioe) {
        LOGGER.warn("Error taking screenshot");
      } finally {
        tearDown();
      }
    }

    public void tearDown() {
      LOGGER.info("Quitting browser");
      driver.quit();

      LOGGER.info("Stopping Chrome Driver Service");
      chromeDriverService.stop();
    }
  };