@Parameters({ "browserType", "appURL" })
@BeforeSuite
public void initializeTestBaseSetup(String browserType, String appURL) {
    try {
        setDriver(browserType, appURL);

    } catch (Exception e) {
        System.out.println("Error....." + e.getStackTrace());
    }
}