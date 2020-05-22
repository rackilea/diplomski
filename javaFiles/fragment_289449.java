JsonNode root = new XmlMapper().readTree(xml.getBytes());
    ObjectMapper mapper = new ObjectMapper();
    root.forEach(node -> consume(node, mapper));



private void consume(JsonNode node, ObjectMapper mapper) {
    try {
        Staff staff = mapper.treeToValue(node, Staff.class);
        //TODO your job with staff
    } catch (JsonProcessingException e) {
        e.printStackTrace();
    }
}