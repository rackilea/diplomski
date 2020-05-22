List<String> lstUrls = new ArrayList<String>();
List<WebElement> lstEle = driver.findElements(By.xpath("//div/div/ul/li['$footer_links']/a"));
for (WebElement element : lstEle)
    lstUrls.add(element.getAttribute("href"));

for (String string : lstUrls) {
    driver.get(string)
    File srcFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    File targetFile1 = new File("D:\\DataPineScreenshots\\" +  driver.getTitle() + ".png");
    FileUtils.copyFile(srcFile1, targetFile1);
    driver.navigate().back();
    System.out.print(footer_links + "\n");
}