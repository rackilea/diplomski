public class DefaultMutableTreeNodeDeserializer extends JsonDeserializer<DefaultMutableTreeNode> {

    @Override
    public DefaultMutableTreeNode deserialize(JsonParser parser, DeserializationContext context)
            throws IOException {
        return parser.readValueAs(POJO.class).toDefaultMutableTreeNode();
    }

    private static class POJO {

        private boolean allowsChildren;
        private Object userObject;
        private List<POJO> children;
        // no need for: POJO parent

        public DefaultMutableTreeNode toDefaultMutableTreeNode() {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode();
            node.setAllowsChildren(allowsChildren);
            node.setUserObject(userObject);
            if (children != null) {
                for (POJO child : children) {
                    node.add(child.toDefaultMutableTreeNode());  // recursion
                    // this did also set the parent of the child-node
                }
            }
            return node;
        }

        // Following setters needed by Jackson's deserialization:

        public void setAllowsChildren(boolean allowsChildren) {
            this.allowsChildren = allowsChildren;
        }

        public void setUserObject(Object userObject) {
            this.userObject = userObject;
        }

        public void setChildren(List<POJO> children) {
            this.children = children;
        }
    }
}