public class GrantedAuthorityDeserializer extends JsonDeserializer<Collection<GrantedAuthority>> {

@Override
public Collection<GrantedAuthority> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
        throws IOException, JsonProcessingException {

    JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);
    Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    if (jsonNode.isArray()) {
        // you may have different serialization logic if you want
        for (JsonNode node : jsonNode) {
            authorities.add(new SimpleGrantedAuthority(node.get("authority").asText()));
        }
    }

    return authorities;
  }
}