public enum ConfigurationLoader {
INSTANCE;

private Map<Multikey<String, SourceType>, Configuration> configurations = new HashMap<>();

public Configuration getConfiguration(String confName, SourceType sourceType) {
    Multikey<String, SourceType> key = new Multikey<>(confName, sourceType);

    if (!isConfigurationLoaded(key)) {
        loadConfiguration(confName, sourceType);
    }
    return configurations.get(key);

}

//helper meethod to know if the configuration has been loaded
private boolean isConfigurationLoaded(Multikey<String, SourceType> key) {
    return configurations.get(key) != null;
}

private void loadConfiguration(String confName, SourceType sourceType) {
    if (SourceType.XML == sourceType) {
        loadConfigurationFromXml(confName);
        return;
    }
    if (SourceType.CSV == sourceType) {
        loadConfigurationFromCSV(confName);
        return;
    }
    if (SourceType.ORACLE_DB == sourceType) {
        loadConfigurationFromOracleDb(confName);
        return;
    }
}

private void loadConfigurationFromXml(String confName) {

    //your imlementation to create the configuration from XML file
    // at the end you put the conf in the map
    //.....
    //configurations.put(key, configuration);
}


//Equals for the others methods
//private Configuration loadConfigurationFromCsv(String confName) { ....}
//private Configuration loadConfFromDb(String confName){...}
}