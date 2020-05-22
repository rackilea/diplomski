public abstract class BaseTest {

        protected WebDriver driver;
        protect Database dbCon;
        @Before
        public void setup(){
            driver = new FirefoxDriver();
            //initialize teh connection same way

        }

        @After
        public void tearDown(){
            driver.close();
            dbCon.close() ;
        }
    }