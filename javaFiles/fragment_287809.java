File file = new File("firebug-1.8.1.xpi");
   FirefoxProfile firefoxProfile = new FirefoxProfile();
   firefoxProfile.addExtension(file);
   firefoxProfile.setPreference("extensions.firebug.currentVersion", "1.8.1"); // Avoid startup screen

   WebDriver driver = new FirefoxDriver(firefoxProfile);