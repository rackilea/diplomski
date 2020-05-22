Map<String, String> mobileEmulation = new HashMap<String, String>();
mobileEmulation.put("deviceName", "Google Nexus 5");
Map<String, Object> chromeOptions = new HashMap<String, Object>();
chromeOptions.put("mobileEmulation", mobileEmulation);

// add this
chromeOptions.put("args", Arrays.asList("incognito", "disable-bundled-ppapi-flash",
    "disable-extensions", "profile-directory=Default", "disable-plugins-discovery",
    "start-maximized"));