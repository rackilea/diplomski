package brucey;

import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestExample extends WebDriverBase {

    @Test
    public void testExample() {
        driver.get("https://www.google.com");
        waitSec(driver, 10).until(ExpectedConditions.elementToBeClickable(byId("some WebElement's ID")));
        // ...
    }
}