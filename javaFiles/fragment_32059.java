import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "./libs/chromedriver 4");
         WebDriver driver=new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/zuck/about?lst=100002006436635%3A4%3A1570508289");
        driver.findElement(By.name("email")).sendKeys("<username>");
        driver.findElement(By.name("pass")).sendKeys("<password>");
        driver.findElement(By.name("pass")).submit();
        driver.findElement(By.name("pass")).sendKeys("<password>");
        driver.findElement(By.name("pass")).submit();
        driver.get("https://www.facebook.com/zuck/about?lst=100002006436635%3A4%3A1570508289");
System.out.println(driver.findElement(By.xpath("//span[text()='Birthday']//../following-sibling::div")).getText());

    }

}