@Test
public void homework() throws InterruptedException {
    driver.get("http://www.localhost/litecart/admin/");
    driver.findElement(By.cssSelector("td [name = username]")).sendKeys("admin");
    driver.findElement(By.cssSelector("td [name = password]")).sendKeys("admin");
    driver.findElement(By.cssSelector("div.footer [name = login]")).click();
    List<WebElement> elements = driver.findElements(By.xpath("//ul//li"));
    // elements.size() will give you the total number of elements.
    for (i=1;i<=elements.size(),i++) {// This will iterate through all the elements
            driver.findElement(By.xpath("//ul/li["+i+"]")).click(); // clicking on each li element one by one
            //include wait here
    }
}