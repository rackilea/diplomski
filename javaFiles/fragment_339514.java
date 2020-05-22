driver.get("https://arunelias.in/testing/randomoption.php");    


WebElement allItems = driver.findElement(By.id("gvItemListing"));


List<WebElement> tableId = allItems.findElements(By.tagName("td"));


String optionString = "Option 3"; 

for(int i = 1 ; i< tableId.size() ; i=i+2){

    if(tableId.get(i).getText().equalsIgnoreCase(optionString) ){
        tableId.get(i-1).click();
        break;
    }

}