public Message<T> deserialize(JsonParser jsonParser, DeserializationContext arg1)
    throws IOException, JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    ObjectCodec oc = jsonParser.getCodec();
    JsonNode node = oc.readTree(jsonParser);

    JsonNode timeStamp = node.get("time");
    Timestamp time = mapper.readValue(timeStamp, Timestamp.class);
    JsonNode restAction = node.get("action");
    RestAction action = mapper.readValue(restAction, RestAction.class);
    String type = node.get("type").getTextValue();
    Class<?> clz = Class.forName(type);
    JsonNode list = node.get("data");
    JavaType listType = mapper.getTypeFactory().constructCollectionType(List.class,   clz);
    List <T> data = mapper.readValue(list, listType);

    Message<T> message = new Message<T>;
    message.setTime(time);
    message.setAction(action);
    message.setType(type);
    message.setData(data);

    return message;
}