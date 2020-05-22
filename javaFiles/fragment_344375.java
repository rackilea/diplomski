WebDriverWait wait = new WebDriverWait(driver, 10);

// visible
WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id*='datepicker'][id*='title']")));
button.click();

// or exist
WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id*='datepicker'][id*='title']")));
button.click();