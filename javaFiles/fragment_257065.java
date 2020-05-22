public class MyDriverManager {
private WebDriver webdriver;
@BeforeClass
public static void beforeClass()
{
    WebDriverManager.chromedriver().setup();
    WebDriverManager.firefoxdriver().setup();
    WebDriverManager.edgedriver().setup();
}
@BeforeMethod
public void beforeMethod()
{
    System.out.println( " control is inside beforeMethod now");
    webdriver=new ChromeDriver();
    webdriver.manage().window().maximize();
}
@AfterMethod
public  void AfterMethod()
{
    webdriver.close();
}
@Test
public  void test()
{
    System.out.println( " control is inside test method now");
    webdriver.get("http://www.google.com/");
}

}