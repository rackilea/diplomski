public static void main(String[] args) 
   {
    WebDriver driver=new FirefoxDriver();
    driver.get("https://www.facebook.com/");
    driver.findElement(By.id("email")).sendKeys("mail");
    driver.findElement(By.id("pass")).sendKeys("pwd");
    driver.findElement(By.id("loginbutton")).click();
   }