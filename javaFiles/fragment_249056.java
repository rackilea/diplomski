package yourPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MyWebDriver {

    WebDriver driver =null;

    public void MyWebDriver(){
        System.setProperty("webdriver.chrome.driver", "c:\\Eclipse\\selenium\\chromedriver.exe");
        this.driver = new ChromeDriver();

    }

    public WebDriver getDriver(){
        return this.driver;


    }
}