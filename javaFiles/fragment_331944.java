public static void trimWhitespace(Node node)
{
    NodeList children = node.getChildNodes();
    for(int i = 0; i < children.getLength(); ++i) {
        Node child = children.item(i);
        if(child.getNodeType() == Node.TEXT_NODE) {
            child.setTextContent(child.getTextContent().trim());
        }
        trimWhitespace(child);
    }
}