DesiredCapabilities capabilities = DesiredCapabilities.chrome();

ChromeDriverService service = new ChromeDriverService.Builder()
                            .usingDriverExecutable(new File("/usr/local/chromedriver"))
                            .usingAnyFreePort()
                            .build();
ChromeOptions options = new ChromeOptions();
options.merge(capabilities);    
ChromeDriver driver = new ChromeDriver(service, options);