public class FileUploadPopUp {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "G://ChromeDriver//chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://pdf2doc.com/");

        driver.findElement(By.cssSelector("input[type=file]")).sendKeys("F:\\Selenium Complete Notes.pdf"); 
    }
}