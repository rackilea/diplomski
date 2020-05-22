public boolean update(String path, Map content) {
    try {
        YAMLFactory yamlFactory = new YAMLFactory();
        yamlFactory.enable(YAMLGenerator.Feature.MINIMIZE_QUOTES);

        File file = new File(path);
        ObjectMapper mapper = new ObjectMapper(yamlFactory);
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
        writer.writeValue(file, content);
        return true;
    } catch (Exception e) {
        logger.error("Error during save Yml file {}", path, e);
    }
    return false;
}