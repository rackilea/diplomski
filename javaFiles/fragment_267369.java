public class UserRolesDeserializer extends JsonDeserializer<Roles> {
    @Override
public Roles deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    TreeNode node = p.readValueAsTree();

    if (node instanceof ArrayNode) {
        ArrayNode array = (ArrayNode) node;
        Iterator<JsonNode> contentIter = array.iterator();
        Roles result = new Roles();
        while (contentIter.hasNext()) {
            JsonNode valueNode = contentIter.next();
            if (valueNode.isTextual()) {
                String roleName = valueNode.textValue();

                try {
                    RoleType role = RoleType.valueOf(roleName);
                    result.getRole().add(role);
                } catch (IllegalArgumentException e) {
                    throw new JsonParseException(p,
                        "Can't create roles for user. Unknown role found. '" + roleName + "'", e);
                }
            } else {
                throw new JsonParseException(p, "Can't create roles for user. All roles must be of type string");
            }
        }
        return result;
    } else {
        throw new JsonParseException(p,
            "Can't create roles for user. Unexpected content found. Array expected for element role");
    }

}