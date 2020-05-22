DesiredCapabilities capabilities = DesiredCapabilities.chrome();
ChromeOptions options = new ChromeOptions();
Map<String, Object> prefs = new HashMap<String, Object>();
prefs.put("download.default_directory", "\\remote-ip\path\to\download\directory");
options.setExperimentalOption("prefs", prefs);
capabilities.setCapability(ChromeOptions.CAPABILITY, options);
WebDriver driver = new RemoteWebDriver(new URL("http://gridhubhost:4444/wd/hub"), capabilities);