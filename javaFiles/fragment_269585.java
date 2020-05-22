FirefoxProfile fxProfile = new FirefoxProfile();

    fxProfile.setPreference("browser.download.folderList", 2);
    fxProfile.setPreference("browser.download.manager.showWhenStarting", false);
    fxProfile.setPreference("browser.download.dir","c:\\tmp");
    fxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
    fxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");

    setDriver(TestBench.createDriver(new FirefoxDriver(fxProfile)));