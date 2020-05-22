JsonNode addressNode = node.get("address");
if (addressNode != null)
{
    JsonParser parser = addressNode.traverse();
    parser.setCodec(jp.getCodec());
    Address address = parser.readValueAs(Address.class);
    user.setAddress(address);
}