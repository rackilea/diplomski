String searchedXpath = tableXpath + "/tbody/tr/td[span='" + columnValue + "']/span";
 try {
     WebElement col = driver.findElement(By.xpath(searchedXpath )); 
     System.out.println("Value Found: " + col.getText());
 } 
 catch (NoSuchElementException e) {
     System.out.println("No such value in the table");
 }