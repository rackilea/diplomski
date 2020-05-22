System.setProperty("webdriver.gecko.driver", "C:\\Utility\\BrowserDrivers\\geckodriver.exe");
WebDriver driver = new FirefoxDriver();
driver.navigate().to("https://www.google.com/");
WebElement submit_button = driver.findElement(By.name("q"));
submit_button.sendKeys("Liverpool");
submit_button.submit();
new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.linkText("News"))).click();
List <WebElement> my_list = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("h3.r.dO0Ag>a")));
System.out.println("The list of href links are : ");
for(WebElement element:my_list)
    System.out.println(element.getAttribute("href"));