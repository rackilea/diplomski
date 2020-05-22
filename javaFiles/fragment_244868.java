public class Setup {

public static WebDriver driver;

@BeforeSuite
public void startUp(){

    driver=new FirefoxDriver();
    driver.manage().window().maximize();

}

@AfterSuite
public void tearDown(){

    //driver.quit();
}
}