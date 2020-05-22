System.setProperty("webdriver.gecko.driver", "C:\\path\\to\\geckodriver.exe");
FirefoxOptions options = new FirefoxOptions();
options.setProfile(new FirefoxProfile());
options.setLogLevel(FirefoxDriverLogLevel.FATAL);
options.setAcceptInsecureCerts(true);
options.setHeadless(true);
WebDriver driver = new FirefoxDriver(options);
driver.get("https://www.google.com");