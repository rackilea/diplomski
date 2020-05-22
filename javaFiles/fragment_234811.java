public class Pawan  {

    static WebDriver driver ; 

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user**\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://vets.cm.qa.preview.vca.webstagesite.com/free-first-exam");
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='/santa-monica']~div.select-btn"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("fName"))).sendKeys("Pawan");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("lName"))).sendKeys("Sharma");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("email"))).sendKeys("ps12@gmail.com");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("zip"))).sendKeys("90404");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("phone"))).sendKeys("9697989900");  

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,100)", "");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("getCoupon"))).click();    
    }
}