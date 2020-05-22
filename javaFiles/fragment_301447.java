@Before
    public void setup() throws IOException{
        baseURL = "http://localhost:3006";
        driver = new FirefoxDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }