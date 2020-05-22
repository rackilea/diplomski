@Test
public void testGuayaki() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Download")).click();

    List<WebElement> downloadHeader = driver.findElements(By.xpath("//h2[contains(text(), 'Downloads')]"));
    if(downloadHeader.size() > 0)
    {
        System.out.println("Found h2 header Downloads");
    }
}