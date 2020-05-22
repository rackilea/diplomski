FirefoxProfile profile = new FirefoxProfile();
profile.setPreference("browser.cache.disk.enable", true);
profile.setPreference("browser.cache.memory.enable", true);
profile.setPreference("browser.cache.offline.enable", true);
profile.setPreference("network.http.use-cache", true);
**profile.setPreference("webdriver.load.strategy", "unstable");** // the most important
this.driver = new FirefoxDriver(profile);