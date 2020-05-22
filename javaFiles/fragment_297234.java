//Get all flags containing GB
List<WebElement> tipsGB = driver.findElements((By.xpath("//*[contains(@class,\'flag-icon-gb\')]"))

//Iterate over the list and do your stuff

for(int i=0; i<numberofElementsYouWant<;i++){

  Webelement currentElement = tipsGB.get(i);
  //manipulate your elements here
  currentElement.Dostuff();

}