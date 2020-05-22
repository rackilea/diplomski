import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class DemonstrateGetTextVsGetInnerTextForDisplayNoneElements {

    public static void main(final String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Let's go to a page that mirrors the use case of a div container,
        // with children paragraphs.
        // The difference: this page doesn't have display: none set on the container.
        driver.get("https://www.google.com/intl/en/about/");
        final WebElement container = driver.findElement(By.className("home-hero-copy"));
        final List<WebElement> paragraphs = container.findElements(By.tagName("p"));

        System.out.println("getText() works as normal for *VISIBLE* containers and paragraphs.");

        System.out.println("CONTAINER: " + container.getText());
        System.out.println(
            "LIST OF PARAGRAPHS, Size = " + paragraphs.size() + "   " + paragraphs.toString());
        for (final WebElement paragraph : paragraphs) {
            System.out.println("PARAGRAPH: " + paragraph.getText());
        }

        System.out.println("SET THE JAVA DEBUGGER TO PAUSE RIGHT HERE, "
            + "GO INTO THE BROWSER AND INJECT \"display: none;\" "
            + "as a style on the div.home-hero-copy element to make"
            + "the div and its child paragraphs invisible. "
            + "You can do this by using the developer tools elements panel.");

        System.out.println("If you've made the container invisible, "
            + "you should notice that in the following block of printouts "
            + "that we've still got references to the WebElements (they aren't stale) "
            + "but when we try to getText() while they are invisible from 'display: none;', "
            + "we won't get any text back.");

        System.out.println("CONTAINER: " + container.getText());
        System.out.println(
            "LIST OF PARAGRAPHS, Size = " + paragraphs.size() + "   " + paragraphs.toString());
        for (final WebElement paragraph : paragraphs) {
            System.out.println("PARAGRAPH: " + paragraph.getText());
        }

        System.out.println("Now, let's try getting the text via 'innerText' with a Javascript Executor");

        System.out.println("CONTAINER: " + getInnerText(driver, container));
        System.out.println(
            "LIST OF PARAGRAPHS, Size = " + paragraphs.size() + "   " + paragraphs.toString());
        for (final WebElement paragraph : paragraphs) {
            System.out.println("PARAGRAPH: " + getInnerText(driver, paragraph));
        }

        System.out.println("As you can see, getting inner text works when the element is invisible!");

        driver.quit();
    }

    /**
     * Get the innerText from an element.
     * @param driver    the WebDriver
     * @param element   the element to get innerText from
     * @return  the element's innerText
     */
    public static String getInnerText(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        return (String) executor.executeScript("return arguments[0].innerText", element);
    }
}