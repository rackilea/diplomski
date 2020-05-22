// Before
DesiredCapabilities firefoxCapabs = DesiredCapabilities.firefox();
capabillities.setCapability("version", "26");
capabillities.setCapability("platform", Platform.WINDOWS);

// After 
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability("version", environment.getProperty("SELENIUM_VERSION", "17.0.1"));
capabilities.setCapability("platform", environment.getProperty("SELENIUM_PLATFORM", "XP"));
capabilities.setCapability("browserName", environment.getProperty("SELENIUM_BROWSER", "firefox"));