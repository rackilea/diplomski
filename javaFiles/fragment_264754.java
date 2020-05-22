public class jquerytest
    {

        public static void main(String[] args) throws Exception {

      WebDriver driver = new FirefoxDriver();

      driver.get("https://www.flipkart.com");

      driver.findElement(By.id("fk-top-search-box")).sendKeys("iphone");

      String query ="return $('.search-bar-submit').each(function() { "
                  + "return $(this).css('background-color') == '#fdd922'; }).get(0);";


      Thread.sleep(5000);//wait till page loads replace thread.sleep by any waits

      WebElement searchbox = (WebElement) ((JavascriptExecutor)driver).executeScript(query);

      searchbox.click();


    }
}