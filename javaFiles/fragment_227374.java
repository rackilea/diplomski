ObjectMapper mapper = new ObjectMapper();
mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
String json = "{\"partnerName\":\"PartnerName\",\"mpnId\":\"1234567\",\"profileType\":\"partner_network_profile\",\"links\":{\"self\":{\"uri\":\"/v1/profiles/PartnerNetworkProfile?mpnId=1234567\",\"method\":\"GET\",\"headers\":[]}},\"attributes\":{\"objectType\":\"PartnerNetworkProfile\"}}";
ObjectNode rootNode = (ObjectNode)mapper.readTree(json);
JsonNode typeNode = rootNode.path("attributes");
if (JsonNodeType.OBJECT == typeNode.getNodeType()) {
    System.out.println("Result:" + typeNode.get("objectType").asText());
}