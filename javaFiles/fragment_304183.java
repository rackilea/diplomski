public class MyTest {
   protected WebDriver driver;

   @BeforeClass   //I would even suggest to use @BeforeMethod but that's up to you
   public void setUp() {
      driver = new FirefoxDriver();
      //other instantiations and assignments if necessary
   }

   @Test
   public void login() {
      driver.get("http://watever.com");
      //do whatever
   }

   @Test
   public void someOtherTest() {
      //do something else
   }

   @AfterClass   //or @AfterMethod
   public void tearDown() {
      driver.quit();
   }
}