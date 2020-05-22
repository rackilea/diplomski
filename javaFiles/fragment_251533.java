public class app{   

    public static void main(String[] args) throws Throwable
    {

    System.setProperty("webdriver.ie.driver", "C:\\Automation\\IEDriverServer.exe");
    WebDriver driver = new InternetExplorerDriver();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.promptResponse=prompt('Please enter the USER ID')");

    isAlertPresent(driver);

    String ID = (String) js.executeScript("return window.promptResponse");

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    driver.get("my application URL");
    driver.findElement(By.name("USERID")).sendKeys("username");
    driver.findElement(By.name("user_pwd")).sendKeys("mypwd");
    driver.findElement(By.name("submit")).submit();
    }

    private static void isAlertPresent(WebDriver driver) {
        try 
           { 
               driver.switchTo().alert(); 
               driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  // even though not needed

               isAlertPresent(driver);
           }   // try 
           catch (NoAlertPresentException Ex) 
           { 

           }
   }

}