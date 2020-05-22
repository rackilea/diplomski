import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.WebElement;
public class new_java_class {

public static void main(String[] args) {
  //add the IE web driver path here..
  System.setProperty("webdriver.ie.driver","D:\\selenium web drivers\\IEDriverServer.exe");   

       WebDriver browser = new InternetExplorerDriver();
       //replace the URL of the web page here..
       browser.get("https://example.com/login/");

       WebElement username = browser.findElement(By.name("uname"));                
       username.sendKeys("test_user");

       WebElement password = browser.findElement(By.name("psw"));                
       password.sendKeys("abcd@1234");

       WebElement btn = browser.findElement(By.name("signIn"));                
       btn.click();

}

}