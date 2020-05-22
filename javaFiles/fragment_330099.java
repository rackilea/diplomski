import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {

    public static void main(final String... args) {

        /*
        Properties seleniumProperties = new Properties();
        seleniumProperties.setProperty("webdriver.gecko.driver", "<PATH_TO_DRIVER>");
        System.setProperties(seleniumProperties);
        */
        System.setProperty("webdriver.gecko.driver", "<PATH_TO_DRIVER>");
        WebDriver driver = new FirefoxDriver();

    }

}