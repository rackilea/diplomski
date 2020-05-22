public class snapdeal {

    static WebDriver driver= new FirefoxDriver();

    @Test
    public void test() {
        //Method1 for Opening Browser.
        openBrowser();
        // Method2 for searching     
        searchElement();
    }

    public static void openBrowser(){
        driver.get("http://amazon.in");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public static void searchElement(){

        driver.findElement(By.xpath("//li[@id='nav_cat_2']")).click(); 

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Shoes");

        driver.findElement(By.xpath("//input[@class='nav-submit-input']")).click();

        driver.findElement(By.xpath("//h2[@class='a-size-medium s-inline s-access-title a-text-normal' and contains(text(), \"Fbt Men's 8876 Casual Shoes\")]")).click();
    }

}