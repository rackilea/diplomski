WebDriverWait wait = new WebDriverWait(driver, 10);

for(int i=0; i<7; i++) {
    WebElement element = wait.until(
       ExpectedConditions.visibilityOfElementLocated(
           By.xpath("//button[@class='-cx-PRIVATE-PostInfo__commentsLoadMoreButtonEnabled']")));

     driver.findElement(By.xpath("//button[@class='-cx-PRIVATE-PostInfo__commentsLoadMoreButtonEnabled']")).click();
}