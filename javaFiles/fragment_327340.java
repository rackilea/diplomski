WebElement input = driver.findElement(By.cssSelector("button.pika-button.pika-day"));

Actions actions = new Actions(driver);
actions.moveToElement(input).build().perform(); // this will simulate scroll to the button

(new WebDriverWait(driver,15)).until(ExpectedConditions.visibilityOf(input)).click();