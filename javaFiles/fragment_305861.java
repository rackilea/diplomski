public class testngchecktwo  {

    static WebDriver driver = new FirefoxDriver();
  @Test
  public void testa() throws InterruptedException {
      driver.get("https://company.com/owa");
      driver.manage().window().maximize();
      driver.findElement(By.id("username")).sendKeys("me@company.com");
      driver.findElement(By.id("password")).sendKeys("pass");
      driver.findElement(By.xpath("//input[@value='Sign in']")).click();

      Thread.sleep(5000);
      //click clanedar icon
      driver.findElement(By.xpath("//a[@id='lnkQlCal']/img")).click();
      Thread.sleep(5000);


      //switch to frame where events listed
      driver.switchTo().frame("bLgAAAAA/GWQ3xtO0SIOqswLk6uH4AQDVKQ5oRivJSZbc9pQXHu/BAAAAbHJJAAAC");

      //Click Enter to bring up that small popup instead double click in mouse
      driver.findElement(By.xpath("//div[@id='divVisualTextContainer']")).sendKeys(Keys.ENTER);

     //get hack to orginal window
      driver.switchTo().defaultContent();

      //click this occurance button
      driver.findElement(By.xpath("//button[@id='btn0']")).click();

  }
}