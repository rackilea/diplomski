private WebDriver initializeDriver() throws Exception {
    // Start the server and get the selenium proxy object
    ProxyServer server = new ProxyServer(proxy_port);  // package net.lightbody.bmp.proxy

    server.start();
    server.setCaptureHeaders(true);
    // Blacklist google analytics
    server.blacklistRequests("https?://.*\\.google-analytics\\.com/.*", 410);
    // Or whitelist what you need
    server.whitelistRequests("https?://*.*.yoursite.com/.*. https://*.*.someOtherYourSite.*".split(","), 200);

    Proxy proxy = server.seleniumProxy(); // Proxy is package org.openqa.selenium.Proxy

    // configure it as a desired capability
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(CapabilityType.PROXY, proxy);

    // start the driver   ;
    Webdriver driver = new FirefoxDriver(capabilities);

    return driver;
}