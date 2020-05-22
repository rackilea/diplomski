// open print dropdown
WebDriverWait wait = new WebDriverWait(driver, 10);
wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.print-button"))).click();

// click print button
WebElement printButton = driver.findElement(By.cssSelector("button.print-popup-button"));
printButton.click();