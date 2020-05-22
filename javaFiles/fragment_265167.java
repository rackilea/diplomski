import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClearSubmissionTest{
    public WebDriver driver;
    String baseUrlAdmin = "http://www.google.pl/";

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
    }

  @Test
  public void Testno1() throws Exception  {
      driver.get(baseUrlAdmin);
      Thread.sleep(5000);
  }

    @AfterTest
    public void tearDown() throws Exception {
        driver.close();
    }
}