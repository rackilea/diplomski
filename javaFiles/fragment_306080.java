public String getConfigurationProperty(String name) throws ConfigurationException {
    try {
        // Try to read from my configuration table 
    } catch (SQLException ex) {
        ConfigurationException wrapper = // Some subclass of ConfigurationException that wraps ex
        throw wrapper;
    }
}