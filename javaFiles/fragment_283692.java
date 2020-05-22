String xp = "//ul/li/a[@class='ui-corner-all']";
    List<WebElement> allList = driver.findElements(By.xpath(xp));
    int count = allList.size();
    System.out.println(count);
    for (int i = 0; i < count ; i++) 
    {
        String name = allList.get(i).getText();
        System.out.println(name);
        if(name.contains("Gandhinagar"))
        {
            allList.get(i).click();
            break;
        }

}