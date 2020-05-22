@BeforeClass
public void pomSetup() {

}

@BeforeMethod
public void setup() {
    DriverFactory.setDriver("chrome");
    // Page factory initialized the constructor of BasePO class
    subPage = new SubPage();
}