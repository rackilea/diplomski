DesiredCapabilities capabilities = DesiredCapabilities.chrome();

ChromeDriverService service = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File("/usr/local/chromedriver"))
                    .usingAnyFreePort()
                    .build();
ChromeDriver driver = new ChromeDriver(service, capabilities);