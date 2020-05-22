for (int i = 10; i > 0; i--) {
        try {
            driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            // If we successfully attach to appium, exit the loop.
            i = 0;
        } catch (UnreachableBrowserException e) {
            LOGGER.info("Waiting for Appium to start");
        }
    }