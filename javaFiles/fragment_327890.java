driver.get("https://darksky.net/forecast/40.7127,-74.0059/us12/en");
String currentTemp =          driver.findElement(By.cssSelector(".summary.swap")).getText();
System.out.println("Current Temp:" + currentTemp);
List<WebElement> tempsInTimeLine = driver.findElements(By.cssSelector(".temps  span:last-child"));
int temp = Integer.parseInt(currentTemp.substring(0, 2));
int highestInTimeLine = temp;
int lowestInTimeLine = temp;
for (WebElement tempInTime: tempsInTimeLine) {
String sLIneTemp = tempInTime.getText();
int lineTemp = Integer.parseInt(sLIneTemp.substring(0, 2));
if (lineTemp > highestInTimeLine){
    highestInTimeLine  = lineTemp;
}
if (lineTemp < lowestInTimeLine ){
    lowestInTimeLine = lineTemp;
}

}

System.out.println("Highest Temp:" + Integer.toString(highestInTimeLine));
System.out.println("Lowest Temp:" + Integer.toString(lowestInTimeLine ));