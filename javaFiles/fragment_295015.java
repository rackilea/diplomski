public class MyApplicationConfiguration {
    private static Properties   configKeyValuePairs         = new Properties();
    private static String       configPropertiesFileName    = "Config.properties";

    static {
        InputStream input = null;
        try {
            input = MyApplicationConfiguration.class
                .getResourceAsStream(configPropertiesFileName);

            configKeyValuePairs.load(input);

        } catch (IOException e) {
            // Deal with not being able to load config, could be a fatal error!
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

    public static String getUsername() {
        // ...
    }

    // Implement getters for other configuration key-value pairs
    // DO NOT let configKeyValuePairs be returned to anyone
}