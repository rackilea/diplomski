driver.get("http://qtpselenium.com/");
driver.findElement(By.xpath("//button[contains(.,'Member Login')]")).click();
WebDriverWait wait = new WebDriverWait(driver, 5); // create a WebDriverWait that we will reuse
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Login to Selenium Account')]"))).click();
wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("Some Email ID");
driver.findElement(By.id("login-password")).sendKeys("Some Password");
driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();