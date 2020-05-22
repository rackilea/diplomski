@Value("${metadata.json.file}") //defined in application.context
    private Resource metaJsonFileName;

    public String getJsonFromFile(List<UnitUiItem> uiitems){
        JsonNode root;
        ObjectMapper mapper = new ObjectMapper();
        InputStream stream = metaJsonFileName.getInputStream();

        root = mapper.readTree(stream);
        JsonNode dataNode = root.get("data");
        JsonNode optionDataNode = dataNode.get("storelocation");

        ((ObjectNode)optionDataNode).putArray("units");
       for(UnitUiItem item : uiitems){
        JsonNode unitNode = ((ObjectNode)optionDataNode).withArray("units").addObject();
        ((ObjectNode)unitNode).put("code",item.getCode());
        ((ObjectNode)unitNode).put("displayName",item.getDisplayName());
    }

    LOGGER.info("buildMetaJson exit");
    return root.toString();
    }

    //calling method
    String jsonFeed = getJsonFromFile();
    ObjectMapper mapper = new ObjectMapper();
    response.setData(mapper.readValue(jsonFeed, Map.class));