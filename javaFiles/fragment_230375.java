private void waitForElement(String element) {
 WebDriverWait wait = new WebDriverWait(Driver, 10); // Wait for 10 seconds.
 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
 WebElement element = driver.findElement(By.xpath(element));

}