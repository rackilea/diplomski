WebElement dateWidget = driver.findElement(your locator);
List<WebElement> columns=dateWidget.findElements(By.tagName("td"));

for (WebElement cell: columns){
   //Select 13th Date 
   if (cell.getText().equals("13")){
      cell.findElement(By.linkText("13")).click();
      break;
 }