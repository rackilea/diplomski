import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class answer {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.example.com/");
        //If u want to know the number of radio buttons then use List
        List<WebElement>radioButton = driver.findElements(By.tagName("example"));
        System.out.println(radioButton.size());
        //If u want to select the radio button
        driver.findElement(By.id("example")).click();
        Thread.sleep(3000);
        //If u want the Text in U R console
        for(int i=0;i<radioButton.size();i++) {
            System.out.println(radioButton.get(i).getText());
        } 
        //If u want to check whether the radio button is selected or not
        if(driver.findElement(By.id("example")).isSelected()) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}