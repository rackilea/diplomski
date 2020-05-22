public class StepDefinitions extends ParentSteps {

@Autowired
private LoginPage loginPage;

@Autowired
private HomePage homePage;

@Before
public void init() {
    if (System.getProperty("environment") == null) {
        System.setProperty("environment", "DEV");
    }
}

@After
public void tearDown(Scenario scenario) {
   // Removed quit
   // if(loginPage.getDriver() != null) {
   //     loginPage.getDriver().quit;
  //   }
}
}