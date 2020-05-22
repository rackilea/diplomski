import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.testng.annotations.Test;

    public class Newtours 
    {
        @Test
        public void my_function()
        {
            System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("http://newtours.demoaut.com/");
        }
    }