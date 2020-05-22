List<WebElement> list = driver.findElements(By.xpath("//div[@class='container']//a[@href]"));
Collections.reverse(list);
for (WebElement element : list) {
    String link = element.getAttribute("href");
    System.out.println("Link: " + link + ", Title: " + element.getText());
}