// If chromediver executable is not in your project directory, 
//  point to it with this system variable
System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe"); 

Map<String, Object> chromeOptions = new HashMap<String, Object>();
chromeOptions.put("binary", "path/to/electron/binary");
chromeOptions.put("args", Arrays.asList(" path-to-electron-app"));
//eg.: chromeOptions.put("binary", "D:\\electron-quick-start\\node_modules\\electron-prebuilt\\dist\\electron.exe");
//     chromeOptions.put("args", Arrays.asList(" D:\\electron-quick-start"));
//  for some reason the app arg needs to follow a space on my Windows machine

DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability("chromeOptions", chromeOptions);
capabilities.setBrowserName("chrome");

WebDriver driver = new ChromeDriver(capabilities);