import java.io.File;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.WebDriver;

public class Tests {
    public static void main(String[] args) { // <-- you need a method!
       File file = new File("C:\\selenium\\IEDriverServer.exe");
       System.setProperty("webdriver.ie.driver", file.getAbsolutePath() );  
       WebDriver driver = new InternetExplorerDriver();
    }
}