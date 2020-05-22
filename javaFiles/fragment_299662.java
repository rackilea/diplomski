public class GoogleTesting extends FluentTestNg { 

// Defines the Driver
private static ThreadLocal<WebDriver> WebDriverTL = new ThreadLocal<WebDriver>();

public void setWebdriver(Webdriver driver){
 WebDriverTL.set(driver);
}

@Override 
public WebDriver newWebDriver() { 
 return WebDriverTL.get ();
} 

@beforeMethod
public void launch browser(){
     WebDriver driver = new ChromeDriver();
     setWebdriver(driver);
}

@Test(invocationCount = 2, threadPoolSize = 2) 
public void GoogleTest(){
        goTo("http://google.com");                         
        System.out.println(getCookies());
 } 
}