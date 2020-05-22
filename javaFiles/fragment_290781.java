By byXpath = By.xpath("//strong[contains(text(),'ISBN')]");

List<WebElement> iSBNList = (new WebDriverWait(driver , 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(byXpath)));

for (WebElement element :iSBNList){
    System.out.println(element.getText());
}