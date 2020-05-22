WebDriver driver= new FirefoxDriver();
driver.get("http://www.tirerack.com/content/tirerack/desktop/en/homepage.html");
WebDriverWait wait = new WebDriverWait(driver, 30);
JavascriptExecutor executor = (JavascriptExecutor) driver;

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Select Make')]")));
WebElement we1 = driver.findElement(By.xpath("//div[contains(text(),'Select Make')]"));
executor.executeScript("arguments[0].click();", we1);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vehicle-make")));
WebElement SelectMakedropdown = driver.findElement(By.id("vehicle-make"));      
SelectMakedropdown.sendKeys("BMW");
SelectMakedropdown.sendKeys(Keys.ENTER);
Thread.sleep(1000);

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Select Year')]")));
WebElement we2 = driver.findElement(By.xpath("//div[contains(text(),'Select Year')]"));
executor.executeScript("arguments[0].click();", we2);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vehicle-year")));
WebElement YearSelectDropdown = driver.findElement(By.id("vehicle-year"));
YearSelectDropdown.sendKeys("2011");
YearSelectDropdown.sendKeys(Keys.ENTER);
Thread.sleep(1000);

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Select Model')]")));
WebElement we3 = driver.findElement(By.xpath("//div[contains(text(),'Select Model')]"));
executor.executeScript("arguments[0].click();", we3);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vehicle-model")));
WebElement VehicleSelectDropdown = driver.findElement(By.id("vehicle-model"));
VehicleSelectDropdown.sendKeys("128i Cabriolet Base Model");
VehicleSelectDropdown.sendKeys(Keys.ENTER);