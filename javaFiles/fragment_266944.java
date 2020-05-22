YAMLFactory yaml;
ObjectMapper mapper;

YAMLParser yamlParser = yaml.createParser("file-with-multiple-docs.yaml")
List<ObjectNode> docs = mapper
      .readValues<ObjectNode>(yamlParser, new TypeReference<ObjectNode> {})
      .readAll();