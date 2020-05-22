String operaBrowser = "C:\\......\\opera.exe"

    System.setProperty("webdriver.opera.driver", "C:\\user\drivers\\operadriver.exe");

    ChromeOptions options = new ChromeOptions();
    options.setBinary(operaBrowser);        

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    OperaDriver browser = new OperaDriver(capabilities);

    WebDriver driver =browser;
    driver.get("https://www.google.com/");