//find the table on the page
WebElement tblEle = driver.findElement(By.id("myTable"))
List<WebElement> tblElements = tblEle.findElements(By.Xpath("/tbody/tr/"));
for (WebElement tblElementRow : tblElements) {
    List<WebElement> allTds = tblElementRow.findElement(By.xpath("td"))
    // do somthing with the list of allTds
}