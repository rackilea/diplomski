ChromeOptions options = new ChromeOptions();
Map<String, Object> preferences = new Hashtable<String, Object>();
options.setExperimentalOption("prefs", preferences);

// disable flash and the PDF viewer
preferences.put("plugins.plugins_disabled", new String[] {
    "Chrome PDF Viewer"
});

// launch the browser and navigate to the page
ChromeDriver driver = new ChromeDriver(options);