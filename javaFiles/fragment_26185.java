List<WebElement> rows = driver.findElement(By.tagName("table")).findElements(By.tagName("tr"));

for(WebElement row : rows) 
 {
   List<WebElement> columns = row.findElements(By.tagName("td"));
    for(WebElement column : columns) 
      {
        String columnText = column.getText();     
       }
   }