WebDriverWait wait = new WebDriverWait(driver, 10);

//First click on dropdown to show options 
WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("select2-drop")));
dropdown.click();

//Now find desired option and click 
wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//li[normalize-space(.) = 'Apples']"))).click();