private Properties _properties;

private void init(){
     _properties = new Properties();
     InputStream configurationFileIS = PropertiesConfigurationHandler.class.getClassLoader().getResourceAsStream(CONFIGURATION_FILE);
     _properties.load(configurationFileIS);
}

public String getStringValue(String path) {
    return _properties.getProperty(path);
}