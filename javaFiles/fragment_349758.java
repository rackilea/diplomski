package pkYourPackage;

    import java.util.List;

    import org.openqa.selenium.By;
    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;


    // http://demo.opencart.com/index.php?route=product/category&path=24

    public class OpenCart_StackOverflow {
        static WebDriver driver;
        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver", "C:/.....put_ path/chromedriver.exe");
            driver = new ChromeDriver();

            driver.get("http://demo.opencart.com/index.php?route=product/category&path=24");
            try{Thread.sleep(5000);}catch(Exception e){}

            List<WebElement> list = driver.findElements(By.xpath("//button[contains(@data-original-title,'Compare this')]/i"));
            for(int i = 0 ; i < list.size() ; i++){
                list.get(i).click();

                try{Thread.sleep(1500);}catch(Exception e){}

            }
            try{Thread.sleep(1500);}catch(Exception e){}

            // click on 'product comparison' to compare
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[contains(text(),'product comparison')]")));
            try{Thread.sleep(10000);}catch(Exception e){}
            driver.close();
            driver.quit();

        }
    }