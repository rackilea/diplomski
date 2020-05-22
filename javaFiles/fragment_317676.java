public Map<String, Object> consumeFile(File yamlFile, Map<String, Object> map){
    YamlConfiguration config = YamlConfiguration.loadConfiguration(yamlFile);
    for (String path : config.getKeys(true)){
        if (config.get(path) != null){
            map.put(path, config.get(path));
        }
    }
    return map;
}