import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import cucumber.api.testng.AbstractTestNGCucumberTests;

public class Hooks extends AbstractTestNGCucumberTests {

    @Parameters({ "browser" })
    @BeforeTest
    public void setUpScenario(String browser){
        //BaseSteps.getInstance().getBrowserInstantiation(browser);
    }
}