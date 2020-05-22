@Before
public void setup(){
    DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("noReset","true");
            capabilities.setCapability("fullReset","false");
            capabilities.setCapability("automationName","Appium");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("VERSION", "5.1.1");
            capabilities.setCapability("deviceName", "LG Nexus 5");
            capabilities.setCapability("appPackage", "com.packageName");
            capabilities.setCapability("appActivity", "ui.activity.SplashScreenActivity");
driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
}

@Test
public void sampleTest(){
//Testing Code Only
}

//To Exit/Quit close the driver
    @After
    public void teardown() {
        if (driver != null)
            driver.quit();
    }