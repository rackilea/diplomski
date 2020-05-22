if (driver.findElements(By.cssSelector("a.mx-name-159b6aef-dbc3-5b23-a735-cf99f8341771-1-3").size() != 0) {
    WebElement element= driver.findElement(By.cssSelector("a.mx-name-159b6aef-dbc3-5b23-a735-cf99f8341771-1-3"))
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("arguments[0].click();", element);
}
 else{
          System.out.println("Element not present");
     }