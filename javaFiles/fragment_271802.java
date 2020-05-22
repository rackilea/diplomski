package stackoverflow;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.testng.annotations.*;

    public class DemoTestNGClass {
        public static WebDriver driver;
        @BeforeMethod
        public void setUp1() throws Exception {

            driver= new ChromeDriver();


        }
        @Test
        public void Homepage() throws InterruptedException {
    //Your operation
        }

        @Test
        public void ListingPage() throws InterruptedException {

    //Your operation
        }

        @AfterMethod
        public void afterresult(){
            driver.close();
        }

    }