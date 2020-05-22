package 123;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TestUnu extends Abstract {

    @Test
    public void testulUnuCompletareFlexi() throws Throwable {
        /*
        * Change in code here
        */
        CompletareFlexi CompletareFlexi = PageFactory.initElements(driver, CompletareFlexi.class);
        CompletareFlexi.completareFlexiCampuri();
    }
}