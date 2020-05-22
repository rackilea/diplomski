// Pass Id value as id1, id2 , id3, or id4
public void finddetailByID(String id)
{
    List <WebElement> tablerows= driver.findElements(By.xpath("//tr[.//td[contains(text(),'"+id+"')]]/td"));
    int rowsize=tablerows.size();
    String availabebalance=tablerows.get(rowsize).getText();
    String balance=tablerows.get(rowsize-1).getText();
}