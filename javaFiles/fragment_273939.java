public class Lesnov {

    static WebDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) throws InterruptedException {
         System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, 40);
            driver.get("https://www.olx.ua/obyavlenie/audi-a4-1998-IDzaH8c.html#c890172227;promoted");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class^='contact-button']")));
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='spoiler']")));
            driver.findElement(By.cssSelector("span[class='spoiler']")).click();
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("strong[class='xx-large']>span[class='block']")));
            List<WebElement> numbers = driver.findElements(By.cssSelector("strong[class='xx-large']>span[class='block']"));
            for(WebElement num : numbers){
                System.out.println(num.getText());
            }

    }

    }