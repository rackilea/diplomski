public Map read(String path) {
    ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    try {
        File file = new File(path);
        Map map = mapper.readValue(file, Map.class);
        return map;
    } catch (Exception e) {
        logger.error("Error during read Yml file {}", path, e);
    }
    return new HashMap();
}