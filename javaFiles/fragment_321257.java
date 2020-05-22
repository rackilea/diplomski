DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","ANDROID");
        capabilities.setCapability("platformVersion", "5.1");
        capabilities.setCapability("platformName",Constant.appPlatform);
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", Constant.appPackage);
        capabilities.setCapability("appActivity",Constant.appActivity);