// find all the rows in the outer table
List<WebElement> outerLIElementList = driver.findElements(
        By.xpath(".//*[@id='chatComponent']/div/swx-navigation/div/div/div/div[2]/div[1]/div/ul/li"));

System.out.println(outerLIElementList.size());

// iterate through the rows in the outer element
for (WebElement outerLIElement : outerLIElementList) {

    // find the inner table rows using the outer table row
    List<WebElement> innerLIElementList = outerLIElement.findElements(By.xpath("//div/ul/li[*]"));

    // iterate through the inner table rows and sysout
    for (WebElement innerLIElement : innerLIElementList) {
        System.out.println(innerLIElement.getText());
    }
}