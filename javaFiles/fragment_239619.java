public class MyTest {

    WebDriver driver;

    @BeforeClass
    public static void setUpClass() {
        driver = new RemoteWebDriver(new URL(hubAddress), capability);
    }

    @AfterClass
    public static void setDownClass() {
         driver.quit();
    }

    @Test 
    public void Test1(){
         driver.get(...);
    }

    @Test 
    public void Test2(){
         driver.get(...):
    }
}