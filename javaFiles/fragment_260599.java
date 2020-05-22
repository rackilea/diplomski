Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
    String browserName = cap.getBrowserName().toLowerCase();
    System.out.println(browserName);
    String os = cap.getPlatform().toString();
    System.out.println(os);
    String v = cap.getVersion().toString();
    System.out.println(v);