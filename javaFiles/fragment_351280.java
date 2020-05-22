package fluent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.seleniumhq.selenium.fluent.FluentWebDriver;
import org.seleniumhq.selenium.fluent.Period;
import org.seleniumhq.selenium.fluent.TestableString;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.className;

public class Test {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        FluentWebDriver fwd = new FluentWebDriver(driver);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://www.hudku.com/search/business-list/Paint%20%26%20Hardware%20in%20Kanakapura%20Road,%20Bangalore,%20Karnataka,%20India?p=6&h1=mgK%3DFsPlSAsPTaOVwo%2F0FIMA");

        driver.navigate();

        TestableString test = fwd.div(className("heading")).within(Period.secs(3)).getText();

        System.out.println("header: " + test.toString());

        test.shouldContain("Paint");

        System.out.println("all is fine!");
    }
}