Map prefs = new HashMap<String, Object>();
prefs.put("profile.default_content_setting_values.geolocation", 1); // 1:allow 2:block

ChromeOptions options = new ChromeOptions();
options.setExperimentalOption("prefs", prefs);

ChromeDriver driver = new ChromeDriver(options);

((LocationContext)driver).setLocation(new Location(37.774929, -122.419416, 0));
driver.get("https://html5demos.com/geo/");