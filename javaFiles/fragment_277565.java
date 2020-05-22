import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class phantomJS_launch {

    public static void main(String[] args) {


          File path=new File("C:\\Utility\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
          System.setProperty("phantomjs.binary.path",path.getAbsolutePath());
          WebDriver driver= new PhantomJSDriver();
          driver.get("https://www.google.co.in");
          System.out.println(driver.getTitle());
          driver.quit();

    }

}