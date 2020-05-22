package SessionPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionCalss {

    public static void main(String arg[])
    {
        System.out.println("String"); 

        WebDriver driver;

        System.setProperty("webdriver.gecko.driver", "C:\\New folder\\geckodriver.exe");
        driver=new FirefoxDriver(); 

        driver.get("www.gooogle.com");

    }
}