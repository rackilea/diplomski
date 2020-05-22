private static BrowserMobProxy proxy = new BrowserMobProxyServer();
public webLib(String browser) {
        logReport.logMethodStart("Launch Application");
        Proxy seleniumProxy = null;
        proxy.start();
        seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

        if (browser.equalsIgnoreCase("chrome")) {
            try {
                System.setProperty("webdriver.chrome.driver",
                        new File(".").getCanonicalFile() + seperator + "WebDriver" + seperator + "chromeDriver.exe");
            } catch (IOException e) {
                e.printStackTrace();
            }

            ChromeOptions options = new ChromeOptions();

            options.setCapability(CapabilityType.PROXY, seleniumProxy);
            options.setAcceptInsecureCerts(true);
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--no-sandbox");
            options.addArguments("--no-sandbox");

            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {

        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        if (driver != null) {
            logReport.logStep(Status.PASS, "Browser launched successfully", driver);
        }

    }