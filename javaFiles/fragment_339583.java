package queries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SQ34442686 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("http://automationpractice.com/index.php?id_product=4&controller=product");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//*[text()='Add to cart']")).click();;
        driver.findElement(By.xpath(".//a[contains(@title,'Proceed to checkout')]")).click();
        driver.close();
    }

}