FirefoxOptions options = new FirefoxOptions();
options.setPreference("browser.download.folderList", 2);
options.setPreference("browser.download.dir", "C:\\Windows\\temp");
options.setPreference("browser.download.useDownloadDir", true);
options.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
options.setPreference("pdfjs.disabled", true);  // disable the built-in PDF viewer

WebDriver driver = new FirefoxDriver(options);
driver.get("https://www.mozilla.org/en-US/foundation/documents");
driver.findElement(By.linkText("IRS Form 872-C")).click();