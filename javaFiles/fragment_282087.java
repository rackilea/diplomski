FirefoxOptions options = new FirefoxOptions();
ProfilesIni allProfiles = new ProfilesIni();         
FirefoxProfile selenium_profile = allProfiles.getProfile("selenium_profile");
options.setProfile(selenium_profile);
options.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
System.setProperty("webdriver.gecko.driver", sec_var.driver_path);
driver = new FirefoxDriver(options);
driver.manage().window().maximize();