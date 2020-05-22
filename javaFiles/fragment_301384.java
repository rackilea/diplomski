ObjectMapper mapper = new ObjectMapper();
final JsonNode jsonNode = mapper.readTree(JSON);
for (JsonNode node : jsonNode)
{
    final Device device = mapper.convertValue(node,
                                              Device.class);
    // do something with the device
}