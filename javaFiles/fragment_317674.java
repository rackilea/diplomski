public void consumeFile(File yamlFile, BiConsumer<? super String, ? super Object> consumer){
    YamlConfiguration config = YamlConfiguration.loadConfiguration(yamlFile);
    for (String path : config.getKeys(true)){
        if (config.get(path) != null){
            consumer.accept(path, config.get(path));
        }
    }
}