String json = "{\"1234345\":[{\"queue\":\"XXX\",\"name\":\"XXXXX\",\"entries\":["
            + "{\"points\":54,\"isInactive\":false}],\"tier\":\"ASDF\"}],"
            + "\"22683144\":[{\"queue\":\"XXX\",\"name\":\"XXXXX\",\"entries\":["
            + "{\"points\":54,\"isInactive\":false}],\"tier\":\"ASDF\"}]}";

ObjectMapper mapper = new ObjectMapper();
Map<String, Object> map = 
    mapper.readValue(json, new TypeReference<Map<String, Object>>() {});