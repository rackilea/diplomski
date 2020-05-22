public void captureScreenshot(String methodName) {
            try {
                new File(screenshotDirectory).mkdirs();
                String filename = methodName + ".png";
                AppiumDriver webDriver = (AppiumDriver) webDriverService.getWebDriver();
                webDriver.context("NATIVE_APP");
                File screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot, new File(screenshotDirectory + filename));
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    };