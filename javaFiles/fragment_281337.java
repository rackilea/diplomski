WebDriver driver= new FirefoxDriver();
driver.get("http://www.tirerack.com/content/tirerack/desktop/en/homepage.html");
WebDriverWait wait = new WebDriverWait(driver, 30);

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Select Make')]")));
driver.findElement(By.xpath("//div[contains(text(),'Select Make')]")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vehicle-make")));
Select SelectMakedropdown = new Select(driver.findElement(By.id("vehicle-make")));      
SelectMakedropdown.selectByVisibleText("BMW");

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Select Year')]")));
driver.findElement(By.xpath("//div[contains(text(),'Select Year')]")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vehicle-year")));
Select YearSelectDropdown = new Select(driver.findElement(By.id("vehicle-year")));
YearSelectDropdown.selectByVisibleText("2011");

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Select Model')]")));
driver.findElement(By.xpath("//div[contains(text(),'Select Model')]")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vehicle-model")));
Select VehicleSelectDropdown = new Select(driver.findElement(By.id("vehicle-model")));
VehicleSelectDropdown.selectByVisibleText("128i Cabriolet Base Model");

driver.quit();