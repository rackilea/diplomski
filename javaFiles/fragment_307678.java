@BeforeMethod
public void beforeMethod() {
  PropertiesFile data = new  PropertiesFile();
  driver = new FirefoxDriver();
  wt = new WaitTypes(driver);
  login = new LoginPageFactory(driver);
  voices = new VoicesPageFactory(driver);
  sa = new SoftAssert();



  //Starting the Web Browser and navigating to the UVA Voices development environment


    data.readPropertiesFile();
    String baseURL = data.getPropertyValue("url");
        test.log(LogStatus.INFO, "Browser Started");
        log.info("Browser started");
        driver.manage().window().maximize();
        driver.get(baseURL);

}