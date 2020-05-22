//using a mapper(important subject the mapper is)
ObjectMapper mapper = new ObjectMapper();
ArrayNode array = mapper.createArrayNode();

//using an existing ArrayNode from a JsonNode
ArrayNode array = json.withArray("fieldName");

//or using Play's Json helper class
ArrayNode array = Json.newArray();