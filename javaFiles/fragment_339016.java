//Wait for the next button
WebDriverWait wait = new WebDriverWait(driver, 10);
click_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.Xpath("//div[@id='paging']//a[@class='next']/span[text()='next']")));

//Click next button
click_button.click();