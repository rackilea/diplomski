package demo;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

    public static void main(String[] args) throws Exception {

        String sDriverPath = "C:\\Utility\\BrowserDrivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", sDriverPath);
        String statusCode;
        final String URL = "https://www.starwars.com/";
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        List<WebElement> socialMenu = driver.findElements(By.xpath("//div[@id='nav-external-links']//a")); 
        System.out.println("Total Amenities "  + socialMenu.size());
        for (WebElement e : socialMenu)
        {
            String href = e.getAttribute("href");
            System.out.println(e.getAttribute("href"));
            HttpURLConnection connection = (HttpURLConnection) new URL(href).openConnection();
            connection.connect();
            statusCode = connection.getResponseMessage();
            connection.disconnect();
            if(!statusCode.contains("200")) {
                System.out.println(href + " gave a response code of " + statusCode);
            }
        }
    }
}