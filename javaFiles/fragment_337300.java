public class BrowserFactory {

    private WebDriver driver;
    private static BrowserFactory browserFactoryInstance = null;

    private BrowserFactory(String Brwsr, String URL) {

        System.out.println(Brwsr.toLowerCase());
        switch (Brwsr.toLowerCase()) {

        case "firefox":
            this.driver = new FirefoxDriver();
            break;
        case "chrome":
            System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
            this.driver = new ChromeDriver();
            break;

        case "internet explorer":
            System.out.println("IE");
            System.setProperty("WebDriver.IE.driver", "IEDriverServer.exe");
            this.driver = new InternetExplorerDriver();
            break;
        default:
            System.out
                    .println("Please select one of the Browsers listed : Chrome,Firefox or InternetExplorer");
            break;
        }

        this.driver.manage().window().maximize();
        this.driver.get(URL);

    }

    public static BrowserFactory getInstance(String Brwsr, String URL) {
        if(browserFactoryInstance == null) {
            browserFactoryInstance = new BrowserFactory(Brwsr, URL);
        }
        return browserFactoryInstance;
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}