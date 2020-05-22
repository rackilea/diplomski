public void openBrowserInPrivacyMode(boolean isBrowserActive) {
    System.setProperty("webdriver.ie.driver", "path/to/IEDriverServer_x32.exe"); 
    DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();  
    capabilities.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);  
    сapabilities.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
    InternetExplorerDriver driver = new InternetExplorerDriver(capabilities);