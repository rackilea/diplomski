public class DefaultMutableTreeNodeSerializer extends JsonSerializer<DefaultMutableTreeNode> {

    @Override
    public void serialize(DefaultMutableTreeNode node, JsonGenerator gen, SerializerProvider serializers)
            throws IOException {
        gen.writeStartObject();
        gen.writeBooleanField("allowsChildren", node.getAllowsChildren());
        gen.writeObjectField("userObject", node.getUserObject());
        if (node.getChildCount() > 0)
            gen.writeObjectField("children", Collections.list(node.children()));
        // Don't write node.getParent(), it would lead to infinite recursion.
        gen.writeEndObject();
    }
}