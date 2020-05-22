WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("myxpath")));

JavascriptExecutor js = (JavascriptExecutor)driver; 

// expand the Select dropdown
js.executeScript("arguments[0].click();", element);

// wait for Select options menu to expand
WebElement optionToClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("xPathForDropdownOption")));

// select desired option
js.executeScript("arguments[0].click();", optionToClick);