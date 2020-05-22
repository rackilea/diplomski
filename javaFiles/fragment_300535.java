driver.get("chrome://settings/content/pdfDocuments");
new WebDriverWait(driver, 10).until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("body/deep/#control"), 10));
driver.findElements(By.cssSelector("body/deep/#control")).get(10).click();
Thread.sleep(2000); // only to see the result

driver.get("https://www.anotherPage.com/");