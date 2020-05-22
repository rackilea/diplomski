private static void method(Config config) {
    for( Entry<String, ConfigValue> element : config.entrySet()){
        String key = element.getKey();
        map.put(key, config.getStringList(key));
    }
}