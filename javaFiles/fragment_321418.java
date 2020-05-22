public class Hooks {
    private static boolean beforeSuit = true;
    private static String executablePath;
    static Properties prop;

    @Before
    public void beforeAll() {
        if(beforeSuit) {
            prop = new Properties();
            ClassLoader loader = Thread.currentThread().getContextClassLoader();           
            InputStream stream = loader.getResourceAsStream("/config.properties");
            prop.load(stream);
            //You can use this anywhere you want to launch the chrome.
            executablePath = prop.getProperty("executablePath");
            //To make it execute only once
            beforeSuit = false;

            //If you wish to launch browser only once , you can have that code here.
        }

        //Here you can keep code to be execute before each scenario

    }
}