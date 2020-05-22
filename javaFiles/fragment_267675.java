String downloadFilepath = "C:\\Utility\\OP_Resources\\MozillaFirefoxDownload";
System.setProperty("webdriver.gecko.driver", "C:\\Utility\\BrowserDrivers\\geckodriver.exe");
FirefoxProfile Profile = new FirefoxProfile();
Profile.setPreference("browser.download.dir",downloadFilepath);
Profile.setPreference("browser.download.folderList",2);
//neverAsk - saveToDisk - CSV        
Profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/csv,application/excel,application/vnd.ms-excel,application/vnd.msexcel,text/anytext,text/comma-separated-values,text/csv,text/plain,text/x-csv,application/x-csv,text/x-comma-separated-values,text/tab-separated-values");
//neverAsk - saveToDisk - ANY       
Profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/xml,text/plain,text/xml,image/jpeg,application/octet-stream");
Profile.setPreference("browser.download.manager.showWhenStarting",false);
//neverAsk - openFile - CSV
Profile.setPreference("browser.helperApps.neverAsk.openFile","application/csv,application/excel,application/vnd.ms-excel,application/vnd.msexcel,text/anytext,text/comma-separated-values,text/csv,text/plain,text/x-csv,application/x-csv,text/x-comma-separated-values,text/tab-separated-values");
//neverAsk - openFile - ANY
Profile.setPreference("browser.helperApps.neverAsk.openFile","application/xml,text/plain,text/xml,image/jpeg,application/octet-stream");
Profile.setPreference("browser.helperApps.alwaysAsk.force", false);