ChromeOptions options = new ChromeOptions();
options.addArguments("--disable-web-security"); // don't enforce the same-origin policy
options.addArguments("--disable-gpu"); // applicable to windows os only
options.addArguments("--user-data-dir=~/chromeTemp"); // applicable to windows os only
WebDriver driver = new ChromeDriver(options);
driver.get("https://google.com");