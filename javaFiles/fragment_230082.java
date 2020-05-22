public static WebDriver driverSetUp(WebDriver driver) throws MalformedURLException {

ChromeOptions options = new ChromeOptions();
options.addArguments("-incognito");
DesiredCapabilities capability = DesiredCapabilities.chrome();
capability.setCapability(ChromeOptions.CAPABILITY, options);
//System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/Documents/:Proj_folder:/chromedriver");
System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
capability.setBrowserName("chrome");
capability.setCapability("nativeEvents", true);
LoggingPreferences logs = new LoggingPreferences();
//Javascript console logs from the browser
logs.enable(LogType.BROWSER, Level.WARNING);
logs.enable(LogType.PERFORMANCE, Level.ALL);
capability.setCapability(CapabilityType.LOGGING_PREFS, logs);
String webDriverURL = "http://" + environmentData.getHubIP() + ":" + environmentData.getHubPort() + "/wd/hub";
log.info("creating driver instance on the URL :#### " + webDriverURL);
driver = new RemoteWebDriver(new URL(webDriverURL), capability);
driver.manage().window().maximize();
return driver;}





public static WebDriver driverInit(WebDriver driver, String startingUrl) throws MalformedURLException {
    driver = DriverInit.driverSetUp(driver);
    driver.get(startingUrl);

    return driver;
}