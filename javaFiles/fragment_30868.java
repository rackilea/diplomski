File app= new File("project/platforms/android/build/outputs/apk/android-debug.apk");
        DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android-Dev");
        capabilities.setCapability("platformVersion", "4.4.4");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "MobilePlatform.ANDROID");
        capabilities.setCapability("app", app.getAbsolutePath());