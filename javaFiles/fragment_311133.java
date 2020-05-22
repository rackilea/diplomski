WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
//Note this isn't giving you the titles, it's giving you the entire list item
By bookSearchResults = By.xpath(".//*[@id='atfResults']/ul[@id='s-results-list-atf']/li");

wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(bookSearchResults, 1));

//Then continue on as you were
List<WebElement> result = driver.findElements(bookSearchResults);
....