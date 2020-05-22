public static AndroidDriver<MobileElement> driver=null;
    public static AppiumDriverLocalService service=null;

    service = AppiumDriverLocalService.buildDefaultService();
    DesiredCapabilities capabilities = new DesiredCapabilities();  
    capabilities.setCapability("platormName", "Android");  
    capabilities.setCapability("deviceName", "Redmi");  
    capabilities.setCapability("appPackage","com.ls.stockpair");  
    capabilities.setCapability("appActivity","com.ls.stockpair.activity.SplashActivity");  

    service.start();
    driver = new AndroidDriver<MobileElement>(service, capabilities);