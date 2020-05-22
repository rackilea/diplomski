FirefoxBinary bin = new FirefoxBinary(
                 new File(System.getProperty("user.dir"),
                 "/tools/FirefoxPortable/FirefoxPortable.exe"));
DesiredCapabilities capabilities = DesiredCapabilities.firefox();
capabilities.setCapability(FirefoxDriver.BINARY, bin);

WebDriver driver = new RemoteWebDriver(capabilities);
driver.get("http://google.com");