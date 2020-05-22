public class TestNavigateCommands {
     public static void main(String[] args) throws InterruptedException {
            try {                
                  System.setProperty("webdriver.chrome.driver", "/Users/himaja/Documents/chromedriver");
                  WebDriver driver = new ChromeDriver();
                  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                  WebDriverWait wait=new WebDriverWait(driver,50 );

                  driver.manage().window().maximize();

                  driver.navigate().to("https://www.flipkart.com/");          
                  driver.findElement(By.xpath("//button[contains(@class,'YdH8')]")).click();   


                  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Appliances']//span"))));
                  driver.findElement(By.xpath("//a[@title='Appliances']//span")).click();         

            } catch (Exception e) {
                e.printStackTrace();
            }           
        }   
    }