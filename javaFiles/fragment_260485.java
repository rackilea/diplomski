DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
        caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        caps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, " mydomain.com/XYZApplication/");
        caps.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
        caps.setCapability("ignoreProtectedModeSettings", true);
        caps.setCapability("ignoreZoomSetting", true);
caps.setCapability("nativeEvents", false);
        caps.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true); 
        caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); 
        caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);

        driver = new InternetExplorerDriver(caps);
        driver.manage().window().maximize();