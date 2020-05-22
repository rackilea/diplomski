import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) 
@CucumberOptions( plugin={"pretty:target/cucumber-htmlreport.text", "json:target/cucmber-report.json"})

public class CucumberTest { //codes }