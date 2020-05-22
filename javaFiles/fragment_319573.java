@Autowired
    ObjectMapper objectMapper;

    @RequestMapping("/")
    JsonNode home() throws IOException {
        JsonNode jsonNode = objectMapper.readTree(resourceFile.getFile());
        return jsonNode.get("foo").get("bar");
    }