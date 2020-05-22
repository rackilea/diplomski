List <WebElement> listOfLastPrice1;
listOfLastPrice1= driver.findElements(By.cssSelector("[data-column-name='last'][class*='pid']")); 

List<String> listCopyLastPrice1 = new ArrayList<String>();

for (WebElement element : listOfLastPrice1) {
    listCopyLastPrice1.add(element.getText());
}