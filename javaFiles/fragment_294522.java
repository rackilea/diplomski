package headlessBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class TestOne {

public static void main(String[] args) {

    // Declaring and initialising the HtmlUnitWebDriver
    HtmlUnitDriver unitDriver = new HtmlUnitDriver();

    // Necessary set Proxy if you're behind it !!!! 
    unitDriver.setProxy("proxy.YOUR-ORGANIZATION.COM", XXXX);

    // open google.com webpage
    unitDriver.get("http://www.google.com");

    System.out.println("Title of the page is -> " + unitDriver.getTitle());

    // find the search edit box on the google page
    WebElement searchBox = unitDriver.findElement(By.name("q"));

    // type in Selenium
    searchBox.sendKeys("Selenium");

    // find the search button
    WebElement button = unitDriver.findElement(By.name("btnG"));

    // Click the button
    button.click();

    System.out.println("Title of the page is -> " + unitDriver.getTitle());

   }
}