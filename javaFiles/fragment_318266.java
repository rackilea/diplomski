package 123;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import parametrii.Utilitara;

public abstract class Abstract {

    protected WebDriver driver;

    // This constructor is not required
    //public Abstract(WebDriver driver) {
      // this.driver=driver;
    //}

    @Before
    public void setApp(){
        Utilitara util = new Utilitara(driver);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://xxxxx.logon.jsp");
    }

    @After
    public void closeApp(){
        //driver.quit();
    }
}