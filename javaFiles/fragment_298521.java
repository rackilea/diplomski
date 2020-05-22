ObjectMapper mapper = new ObjectMapper();
// example JsonNode
JsonNode arrayNode = mapper.createArrayNode().add("one").add("two");
// acquire reader for the right type
ObjectReader reader = mapper.readerFor(new TypeReference<List<String>>() {
});
// use it
List<String> list = reader.readValue(arrayNode);