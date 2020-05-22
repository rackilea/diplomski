private String getProperty(String key){
    String value = null;
    if (System.getProperties().contains(key))
        value = System.getProperty(key);
    else if (userProperties.containsKey(key))
        value = userProperties.getProperty(key);
    else
        value = defaultProperties.getProperty(key);
}