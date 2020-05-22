public static void main(String[] args) throws InterruptedException {
WebDriver driver = new FirefoxDriver();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.get(
        "http://www.flipkart.com/mobiles/pr?sid=tyy,4io&otracker=clp_mobiles_CategoryLinksModule_0-2_catergorylinks_11_ViewAll");
driver.manage().window().maximize();
// Take everything on the page in list first .
List<WebElement> completecalContent = driver.findElements(By.xpath("//*[@class='fk-display-block']"));
System.out.println(completecalContent.size());
// printing all elements
for (int i = 0; i < completecalContent.size(); i++) {
    System.out.println("Print complete Content : " + completecalContent.get(i).getText());
    if (completecalContent.get(i).getText().equals("Apple iPhone 5S (Space Grey, 16 GB)")) {
        // move to a specific element
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                completecalContent.get(completecalContent.size() - 1));
        // move slightly up as blue header comes in the picture
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-100)");
        // then click on the element
        completecalContent.get(i).click();
    }
}
}