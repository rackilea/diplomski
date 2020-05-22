public class TreeNodeSerializer extends JsonSerializer<TreeNode> {

    @Override
    public void serialize(TreeNode value, JsonGenerator generator,
                          SerializerProvider provider) throws IOException,             JsonProcessingException {

        generator.writeStartObject();
        generator.writeStringField("value", value.getValue());
        generator.writeNumberField("numValue", value.getNumValue());

        generator.writeArrayFieldStart("children");
        for(TreeNode child : value.getChildren()) {
            generator.writeStringField("value", child.getValue());
            generator.writeNumberField("numValue", child.getNumValue());
        }
        generator.writeEndArray();

        generator.writeEndObject();
    }
}