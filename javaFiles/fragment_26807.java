public class Testing_anew {

    public static WebDriver driver;

    public static void main(String args[]) throws InterruptedException{

        driver = new FirefoxDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

      }

    public static void testmethod(){

    driver.findElement(By.xpath("//some xpath")).click();
   }