import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class DemoWindowBasedApplication {


    public static void main(String[] args) throws FindFailed {

        Screen screen = new Screen();
        Pattern image = new Pattern("C:\\Users\\test\\Videos\\snspshot\\october\\12\\google.png");
        Pattern image1 = new Pattern("C:\\Users\\test\\Videos\\snspshot\\october\\12\\testGoogle.png");
        Pattern googleSearch = new Pattern("C:\\Users\\test\\Videos\\snspshot\\october\\12\\googleSearch.png");
        Pattern closeBrowser = new Pattern("C:\\Users\\test\\Videos\\snspshot\\october\\12\\close.png");

        WebDriver driver;
        System.setProperty("webdriver.gecko.driver",
                "D:\\Automation\\Drivers_Automation\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://www.google.com");
        screen.click(image);
        screen.type(image1,"Software testing");
        screen.click(googleSearch);
        screen.click(closeBrowser);
        screen.wait(image, 10);

    }
}