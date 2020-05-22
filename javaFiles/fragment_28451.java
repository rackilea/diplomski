public class verifylogin {

    //STORE YOUR DRIVER SOMEWHERE!!! Like here
    private WebDriver driver;  

    @BeforeTest
    public void beforetest(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\saniket.soni\\Desktop\\chrome\\chromedriver.exe");
        //Store the driver in the class variable
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demosite.center/wordpress/wp-login.php");
    }

    @Test   
    public void verifyvalidlogin(){
        //Now you can use the driver you stored
        LoginPage login_test = new LoginPage(driver);
        login_test.typeusername();
        login_test.typepassword();
        login_test.clickrememberme();
        login_test.clicklogin();    
    }