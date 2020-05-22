public class CustomStringDeserializer extends JsonDeserializer<List<Child>> {

@Override
public List<Child> deserialize(JsonParser parser, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
    List<Child> ret = new ArrayList<>();

    ObjectCodec codec = parser.getCodec();
    ObjectMapper mapper = new ObjectMapper();
    TreeNode node = codec.readTree(parser);

    if (node.isArray()){
        for (JsonNode n : (ArrayNode)node){
            ret.add(mapper.convertValue(n, Child.class));
        }
    } else if (node.isValueNode()){
        ret.add(mapper.convertValue(node, Child.class));
    }
    return ret;
   }
}