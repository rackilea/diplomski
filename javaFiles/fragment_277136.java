WebUI.openBrowser("https://the-internet.herokuapp.com/tables")
WebDriver driver = DriverFactory.getWebDriver()
driver.findElement(By.xpath("//table[@id='table1']//span[contains(.,'Last Name')]")).click()

List<WebElement> tableElements = driver.findElements(By.cssSelector("#table1 tr td:nth-child(1)"));
ArrayList<String> tableValues = new ArrayList<String>();
for(int i=0; i < tableElements.size(); i++){
    String str = tableElements.get(i).getText();
    tableValues.add(str);
}

ArrayList<String> referenceValues = new ArrayList<String>();
for(int i=0; i < tableValues.size(); i++){
    referenceValues.add(tableValues.get(i))         
}

Collections.sort(referenceValues)

assert referenceValues.equals(tableValues)