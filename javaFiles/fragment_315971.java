import static org.testng.Assert.assertNotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OpenSite {
    private WebDriver driver;

    @BeforeClass(alwaysRun=true)
    public void openMain()
    {
      System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
      driver = new ChromeDriver();
      driver.get("http://vtu.ac.in/");
    }

    @Test
    //Clicking on the first link on the page
    public void aboutVTU()
    {
        assertNotNull(driver);
        driver.findElement(By.id("menu-item-323")).click();
    }

    @Test(dependsOnMethods="aboutVTU")
    //clicking on the 2nd link in the page
    public void Institutes()
    {
        assertNotNull(driver);
        driver.findElement(By.id("menu-item-325")).click();
    }
}