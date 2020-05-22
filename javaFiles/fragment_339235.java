driver.get("http://www.redbus.in/Booking/SelectBus.aspx?fromCityId=124&fromCityName=Hyderabad&toCityId=462&toCityName=Mumbai&doj=30-May-2013&busType=Any&opId=0");

//Find's the elements using a CSS selector: all td's (with class "i1"), directly inside a tr (with class r1) which are inside a table.
List<WebElement> linkElements = driver.findElements(By.cssSelector("table tr.r1 > td.i1"));
String[] linksText = new String[linkElements.size()];
int index = 0;
for(WebElement element : linkElements){
    linksText[index++] = element.getText();
}