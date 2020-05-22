public class ApplicationState {

    private static ApplicationState instance = new ApplicationState();

    private ApplicationState() { }
    public static ApplicationState getInstance( ) { return instance; }

    public String read(String key) throws IOException {

        try (InputStream input = new FileInputStream("path/to/config.properties")) {

            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty(key);
        }
    }

    ...
}