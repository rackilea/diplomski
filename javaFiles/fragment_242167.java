public enum Configuration {

    PROPERTY1("property1.name", "default_value_1"),
    PROPERTY2("property2.name", "default_value_2");

    private final String key;
    private String defaultValue;

    Configuration(String key) {
        this(key, NA);
    }

    Configuration(String key, String defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;
    }
    private final static Logger logger = LoggerFactory.getLogger(Configuration.class);
    private final static String NA = "n.a.";
    private final static String CONFIG_FILE = "properties/config.properties";
    private final static String NOT_A_VALID_KEY = "Not a valid property key";
    private final static Map<Configuration, String> configuration = new EnumMap<>(Configuration.class);

    static {
        readConfigurationFrom(CONFIG_FILE);
    }

    private static void readConfigurationFrom(String fileName) {
        logger.info("Reading resource: {}", fileName);
        try (InputStream resource = Configuration.class.getClassLoader().getResourceAsStream(fileName);) {
            Properties properties = new Properties();
            properties.load(resource); //throws a NPE if resource not founds
            for (String key : properties.stringPropertyNames()) {
                configuration.put(getConfigurationKey(key), properties.getProperty(key));
            }
        } catch (IllegalArgumentException | IOException | NullPointerException e) {
            logger.error("Error while reading the properties file {}", fileName, e);
            populateDefaultValues();
        }
    }

    private static Configuration getConfigurationKey(String key) {
        for (Configuration c : values()) {
            if (c.key.equals(key)) {
                return c;
            }
        }
        throw new IllegalArgumentException(NOT_A_VALID_KEY + ": " + key);
    }

    private static void populateDefaultValues() {
        for (Configuration c : values()) {
            configuration.put(c, c.defaultValue);
        }
    }

    /**
     * @return the property corresponding to the key or null if not found
     */
    public String get() {
        return configuration.get(this);
    }
}