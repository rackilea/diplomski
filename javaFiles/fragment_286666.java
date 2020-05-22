public class Home_page {
    private static WebElement element = null;

    public static WebElement txtbox_FirstName(WebDriver driver) {
        element = driver.findElement(By.id("u_0_g"));
        return element;
    }
    Public static WebElement dropdown_BirthDay_Day(WebDriver driver){
        element = driver.findElement(By.id("day"));
        return element;
    }
    Public static WebElement dropdown_BirthDay_Month(WebDriver driver){
        element = driver.findElement(By.id("month"));
        return element;
    }Public static WebElement dropdown_BirthDay_Year(WebDriver driver){
        element = driver.findElement(By.id("year"));
        return element;
    }

}

public class Action_createAccount {

    private static WebDriver driver = null;

    public static void main(String args[]) {

        System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/");


        Home_page.txtbox_FirstName(driver).sendKeys("Anu");
        new Select(Home_page.dropdown_BirthDay_Day(driver)).selectByVisibleText("16");
        new Select(Home_page.dropdown_BirthDay_Month(driver)).selectByVisibleText("Nov");
        new Select(Home_page.dropdown_BirthDay_Year(driver)).selectByVisibleText("1990");
    }
}