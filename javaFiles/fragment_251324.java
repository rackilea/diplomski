ChromeOptions options = new ChromeOptions();
    Map<String, Object> prefs = new HashMap<String, Object>();
    prefs.put("download.prompt_for_download", false);
    prefs.put("download.directory_upgrade", true);
    prefs.put("download.default_directory", "path-to-download-directory");
    options.setExperimentalOption("prefs", prefs);
    WebDriver driver = new ChromeDriver(options);