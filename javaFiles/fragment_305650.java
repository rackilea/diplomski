public class DefaultMutableTreeNodeSerializer implements JsonSerializer<DefaultMutableTreeNode> {

    @Override
    public JsonElement serialize(DefaultMutableTreeNode src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("allowsChildren", src.getAllowsChildren());
        jsonObject.add("userObject", context.serialize(src.getUserObject()));
        if (src.getChildCount() > 0) {
            jsonObject.add("children", context.serialize(Collections.list(src.children())));
        }
        return jsonObject;
    }
}