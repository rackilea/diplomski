List<WebElement> elements  = driver.findElements(By.xpath(actualXpath_1A));
String OneA = "";
if(!elements.isEmpty()){
    OneA = elements.get(0).getText();
} else {
    //Handle if no element present
}