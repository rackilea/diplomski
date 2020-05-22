public class Q44928902_GoogleSearchTest 
{

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest 
    public void SetUp()
    {
        System.setProperty("phantomjs.binary.path", "C:/Utility/phantomjs-2.1.1-windows/bin/phantomjs.exe");
        driver = new PhantomJSDriver();
        System.out.println("=====PhantomJS Driver Initiated=====");
        driver.manage().window().maximize();
        driver.get("https://dev.investmentpunk.academy");
        System.out.println("=====URL Accessed=====");
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void testGoogleSearch() throws InterruptedException
    {
        WebElement Login_btn = driver.findElement(By.xpath("//ul/li[@class='ng-scope']/a[contains(@href,'/db/login/')][text()='EINLOGGEN']"));
        Login_btn.click();
        System.out.println("=====EINLOGGEN button Clicked=====");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Username/Email']"))).sendKeys("user1");
        System.out.println("=====Username Sent=====");

        WebElement Password = driver.findElement(By.xpath("//input[@placeholder='Passwort']"));
        Password.sendKeys("qwerty");
        System.out.println("=====Password Sent=====");

        WebElement Login = driver.findElement(By.xpath("//button[@class='btn btn-blue']"));
        Login.click();
        System.out.println("=====Login button Clicked=====");
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
}