public static List<String> jsonSplit(String o) throws JsonParseException, JsonMappingException, IOException {
    List<String> list = new ArrayList<String>();
    ObjectMapper mapper = new ObjectMapper();
    DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
    printer.indentArraysWith(new Lf2SpacesIndenter());

    JsonNode rootNode = mapper.readValue(o, JsonNode.class); 
    Iterator<String> appName = rootNode.get("data").getFieldNames();
    Iterator<JsonNode> iteNode = rootNode.get("data").getElements();

    while (iteNode.hasNext()){
        list.add(appName.next());
        list.add(mapper.writer(printer).writeValueAsString(iteNode.next()));
    }

    return list;
}