import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class GetData {

    public static void main(String args[]) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://myservices.ect.nl/tracing/objectstatus/Pages/Overview.aspx");
        Thread.sleep(5000);
        // select barge
        new Select(driver.findElement(By.id("ctl00_ctl15_g_ce17bd4b_3803_47f6_822a_2b8dd10fc67d_ctl00_dlModality"))).selectByVisibleText("Barge");
        // click button
        Thread.sleep(3000);
        driver.findElement(By.className("button80")).click();
        Thread.sleep(5000);

        //get only table text
        WebElement findElement = driver.findElement(By.className("grid-view"));
        String htmlTableText = findElement.getText();
        // do whatever you want now, These are raw table values.
        System.out.println(htmlTableText);

        driver.close();
        driver.quit();    
    }
}