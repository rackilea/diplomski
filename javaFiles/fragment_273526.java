WebDriver driver = new ChromeDriver();
driver.get("https://www.icicibank.com/Personal-Banking/loans/personal-loan/index.page");

WebDriverWait wait = new WebDriverWait(driver, 10);

wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='myDivAdd']/a[2]"))).click(); // dismiss popup

wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe"))); // switch to iframe

WebElement firstName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='firstNameId']")));
firstName.click();
firstName.sendKeys("first name");

WebElement lastName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='lastNameId']")));
lastName.click();
lastName.sendKeys("last name");

driver.switchTo().defaultContent();