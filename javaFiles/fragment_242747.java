org.openqa.selenium.support.ui.ExpectedConditions

Webdriver driver = new FirefoxDriver();
//to wait for an element you need a webdriverWait object
WebDriverWait wait = new WebDriverWait(driver, 15);

element = wait.until(ExpectedConditions.presenseOfElementLocated(By.ID("your_id"));