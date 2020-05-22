driver.get("http://www.moneycontrol.com/stocks/advice/display_more.php");   


String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
            + "var elementTop = arguments[0].getBoundingClientRect().top;"
            + "window.scrollBy(0, elementTop-(viewPortHeight/2));";


((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, driver.findElement(By.className("nextBtn")));
    //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
try {
     Thread.sleep(500);
} catch (InterruptedException e) {
}



java.util.List<WebElement> list = driver.findElements(By.xpath("//div[@class='gray2_11']/a"));
int u=list.size();
System.out.println(u);