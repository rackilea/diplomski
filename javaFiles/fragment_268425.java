import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium2Example {
  public static void main(String[] args) {
    WebDriver driver = new FirefoxDriver();
    // local test URL
    driver.get("http://localhost:8080");

    WebElement element = driver.findElement(By.className("slideshow-image"));

    String attribute = element.getAttribute("data-interchange");
    String[] urls = attribute.split(",");

    for (String url : urls) {
      if (url.endsWith("jpg")) {
        System.out.println("URL Info: " + url.replace("[", "").trim());
      }
    }

    // Close the browser
    driver.quit();
  }
}