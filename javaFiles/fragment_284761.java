//Change  Your File Path First.
 private static final String PROPERTIES_FILE_PATH = "ConsumerConfig.properties";

 private static Properties loadPropertiesFile() throws IOException {
        Properties properties = new Properties();
             //First way to load ResourceAsStream.
        //ClassLoader loader = Thread.currentThread().getContextClassLoader();
        //InputStream resourceStream = loader.getResourceAsStream(PROPERTIES_FILE_PATH);

        //Second way to load ResourceAsStream.
        InputStream resourceStream = ConsumeConfig.class.getResourceAsStream(PROPERTIES_FILE_PATH);
        properties.load(resourceStream);
        return properties;
    }