FileConfiguration fc = getConfig(); // Get the config
ConfigurationSection cs = fc.getConfigurationSection("maps");
boolean deep = false; 
for (String key : cs.getKeys(deep)) {
    //Key will be 01
}