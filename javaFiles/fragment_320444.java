System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("https://paytm.com");
System.out.println(driver.getTitle());
new WebDriverWait(driver, 20).until(ExpectedConditions.titleContains("Paytm.com – Digital & Utility Payment, Entertainment, Travel, Payment Gateway & more Online !"));
System.out.println(driver.getTitle());
driver.findElement(By.xpath("//input[@placeholder='Search for a Product , Brand or Category']")).sendKeys("mobile");
driver.findElement(By.xpath("//input[@placeholder='Search for a Product , Brand or Category']")).sendKeys(Keys.ENTER);