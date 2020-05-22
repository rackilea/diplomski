@RunWith(Cucumber.class)
@CucumberOptions(features = { "classpath:features/*.feature" }, glue = "packagename(s) or class name(s) containing the step definitions", plugin = {
        "pretty:target/prettyReport.txt", "html:target/cucumber", "json:target/cucumber.json", "rerun:target/rerun.txt",
        "junit:target/junit-report.xml", "testng:target/testng-output.xml" }, monochrome = true, tags = {"~@Ignore"})
public class FeatureRunnerTest {

}