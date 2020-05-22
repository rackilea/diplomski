System.setProperty("webdriver.gecko.driver", "C:\\Utility\\BrowserDrivers\\geckodriver.exe");
WebDriver driver =  new FirefoxDriver();
driver.get("https://www.redbus.in/");
new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.fl.button#search_btn"))).click();
System.out.println("Search button clicked");
driver.quit();