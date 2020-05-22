public class JUnit4 {

 public WebDriver driver;

 @Before
    public void setup() {
     System.setProperty("webdriver.gecko.driver", "path of the geckodriver ");
       driver = new FirefoxDriver(); 
                  }
 @Test
public void test1() {
    driver.get("https://www.google.pl/");
    }
}