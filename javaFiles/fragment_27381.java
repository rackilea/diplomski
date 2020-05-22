public class autoitclass {

 public WebDriver driver;


@BeforeTest 
public void websitemain()
{
    System.setProperty("webdriver.gecko.driver", "E:\\Softwares\\Testing\\geckodriver.exe");

    driver = new FirefoxDriver();   


    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    String URL = "http://www.megafileupload.com/";

    driver.get(URL);
}

@Test
public void uploadFile() throws Throwable{

    driver.findElement(By.xpath(".//a[contains(@class,'slider-btn')]")).click();        
    driver.findElement(By.xpath(".//*[@id='initialUploadSection']")).click();
    Runtime.getRuntime().exec("E:\\Softwares\\Testing\\FileIUploadAutoit.exe");


}

@AfterTest
public void quit(){

    driver.quit();

}