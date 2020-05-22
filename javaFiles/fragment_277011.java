FirefoxOptions options = new FirefoxOptions();
options.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"); //Location where Firefox is installed

DesiredCapabilities capabilities = DesiredCapabilities.firefox();
capabilities.setCapability("moz:firefoxOptions", options);

FirefoxDriver driver = new FirefoxDriver(capabilities);
driver.get("http://www.google.com");