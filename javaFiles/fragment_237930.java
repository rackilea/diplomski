Use the driver which is returning from obj.setup("chrome");



public class FinalTest {

WebDriver driver;

@BeforeTest
public void beforeTest() throws Exception
{
    Browsersetup obj = new Browsersetup();
    driver = obj.setup("chrome");

    driver.get("http://xxx.xxxxxxxxxxxx.xxx/");
//...........
}