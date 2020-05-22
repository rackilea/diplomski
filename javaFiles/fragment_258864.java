ChromeOptions options = new ChromeOptions();
options.addArgument("--disable-web-security");
options.addArgument("--start-maximized");

// For use with RemoteWebDriver:
DesiredCapabilities capabilities = DesiredCapabilities.chrome();
capabilities.setCapability(ChromeOptions.CAPABILITY, options);
RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);