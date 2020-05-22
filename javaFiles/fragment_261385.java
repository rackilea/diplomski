try {
     DesiredCapabilities capability = DesiredCapabilities.firefox();
     System.setProperty("webdriver.gecko.driver", "/PATH_OF_DRIVER/geckodriver.exe");
     driver = new RemoteWebDriver(new URL("http://Hub_IP/wd/hub"), capability);
     capability.setBrowserName("firefox");
     driver.get("https://www.google.com");

} catch (MalformedURLException ex) {
     System.err.println("URL Exception: "+ex.getMessage());
}