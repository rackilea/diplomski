package demo;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Q44559302_dropdown_select {

    public static void main(String[] args) {


        String innerhtml = null;
        System.setProperty("webdriver.gecko.driver", "C:\\your_directory\\geckodriver.exe");
        WebDriver driver =  new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.o2.co.uk/shop/smartwatches/samsung/gear-s2/#contractType=nonconnected");
        driver.findElement(By.xpath("//form[@id='chooseTariffForm']//div[@class='quantiy-picker-wrapper']/div/span")).click();
        List<WebElement> element_list = driver.findElements(By.xpath("//form[@id='chooseTariffForm']//div[@class='quantiy-picker-wrapper']/div/span/ul/li/a"));
        System.out.println("Number of Elements : "+element_list.size());
        for (int i=0; i<element_list.size(); i++)
        {
            WebElement my_element = element_list.get(i);
            innerhtml = my_element.getText();

            if(innerhtml.contentEquals("4"))
            {
                my_element.click();
                break;
            }


        }
        System.out.println("Value selected from Dropdown is : "+innerhtml);

    }

}