ProxyServer proxyServer = new ProxyServer(9091);
proxyServer.start();    

Proxy proxy = proxyServer.seleniumProxy();
DesiredCapabilities capabilities = DesiredCapabilities.firefox();
// DO NOT set proxy for RemoteWebDriver
// capabilities.setCapability(CapabilityType.PROXY, proxy);
capabilities.setCapability("version", "5");
capabilities.setCapability("platform", Platform.XP);
this.driver = new RemoteWebDriver(
        new URL("http://myname:xxxxxx@ondemand.saucelabs.com:80/wd/hub"),
        capabillities);