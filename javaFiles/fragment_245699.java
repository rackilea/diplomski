private static final Resource resource = new ClassPathResource("/config.properties");
private static final Properties properties = PropertiesLoaderUtils.loadProperties(
    resource
);
private static final List<String> connectionParameters = Arrays.asList(
    properties.getProperty("connection").split(",")
);