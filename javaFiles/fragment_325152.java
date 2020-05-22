public class Newtours  
    {
        public static void main(String[] args) 
        {
            System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");
            WebDriver driver =  new ChromeDriver();
            driver.get("http://newtours.demoaut.com/");
        }
    }