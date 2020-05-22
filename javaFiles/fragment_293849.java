package demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Q45455402_multiple_windows 
{

    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException 
    {
        System.setProperty("webdriver.chrome.driver","C:\\Utility\\BrowserDrivers\\chromedriver.exe");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("password_manager_enabled", false); 
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        driver = new ChromeDriver(options);
        driver.get("http://www.universalmusic.com");
        driver.findElement(By.xpath("//a[@id='main-menu-open']/span")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement our_label = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='main-menu-container']//h3[contains(text(),'Our Labels')]")));
        our_label.click();
        JavascriptExecutor je = (JavascriptExecutor)driver;
        WebElement element = driver.findElement(By.xpath("//div[@id='section-items']/div[@class='items-container']//a[contains(@href,'http://www.universalmusic.com/label/abbey-road-studios/')]"));
        je.executeScript("arguments[0].scrollIntoView(true);",element);
        element.click();
        JavascriptExecutor je2 = (JavascriptExecutor)driver;
        WebElement element2 = driver.findElement(By.xpath("//div[@id='detail-main']//a[@class='button secondary links-button']"));
        je2.executeScript("arguments[0].scrollIntoView(true);",element2);
        String parent_window = driver.getWindowHandle();
        System.out.println("Parent Window ID is : "+parent_window);
        element2.click();
        Set<String> allWindows = driver.getWindowHandles();
        int count = allWindows.size();
        System.out.println("Now Total Windows : "+count);
        for(String child_1:allWindows)
            if(!parent_window.equalsIgnoreCase(child_1))
                driver.switchTo().window(child_1);
        System.out.println(driver.getTitle());
        String child1_window = driver.getWindowHandle();
        System.out.println("Child 1 Window ID is : "+child1_window);
        driver.findElement(By.linkText("Shop")).click();
        Set<String> all_Windows = driver.getWindowHandles();
        int count_final = all_Windows.size();
        System.out.println("Now Total Windows : "+count_final);
        for(String child_2:all_Windows)
            if(!parent_window.equalsIgnoreCase(child_2) && !child1_window.equalsIgnoreCase(child_2))
                driver.switchTo().window(child_2);
        String child2_window = driver.getWindowHandle();
        System.out.println("Child 2 Window ID is : "+child2_window);
        driver.findElement(By.xpath("//div[@id='col1']//a[@class='toggle login']")).click();
    }

}