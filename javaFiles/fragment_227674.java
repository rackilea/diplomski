`
@BeforeTest(alwaysRun = true)
@Parameters({"platform", "udid", "deviceName", "wdaLocalPort","url"})
public void setup1(String platform, String udid, String deviceName, String wdaLocalPort,String url) throws Exception {

driver = GetDTrial.getInstance1().setDriverTrial(platform, udid, deviceName, wdaLocalPort, url);
    homePage = new HomePage(driver);

}
`