static WebDriver browser;
static ChromeOptions options = new ChromeOptions();

System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

options.addArguments("--headless");
options.addArguments("--no-sandbox");
options.addArguments("start-maximized");
options.addArguments("disable-infobars");
options.addArguments("--disable-extensions");

browser = new ChromeDriver(options);