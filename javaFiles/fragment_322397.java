public class ChromeDriverFactory {

    public ThreadLocal<WebDriver> driver;
    private Set<WebDriver> drivers = Collections.newSetFromMap(new ConcurrentHashMap<>());

    public ChromeDriverFactory(Boolean isHeadless) throws IOException
     {
        System.setProperty("webdriver.chrome.driver", TestUtils.getRelativePath() + "/externalLibraries/browsers/chromedriver");
        System.setProperty("java.awt.headless", Boolean.toString(isHeadless));
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setJavascriptEnabled(true);
        caps.setCapability("takesScreenshot", true);
        ChromeOptions options = new ChromeOptions();
        if (isHeadless)
        {
            options.addArguments("headless");
            options.addArguments("disable-gpu");
            //options.addArguments("no-sandbox");
        }
        options.addArguments("disable-extensions");
        caps.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new InheritableThreadLocal<WebDriver>(){
            @Override
            protected ChromeDriver initialValue() {
                ChromeDriver chromeDriver = new ChromeDriver(caps);
                drivers.add(chromeDriver);
                return chromeDriver;
            }
        };
    }

}