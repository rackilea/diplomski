String getXPath(Node node)
{
    Node parent = node.getParent();
    if (parent == null) {
        return "/" + node.getTagName();
    }
    return getXPath(parent) + "/" + "[@id='" + node.getAttribute("id") + "']";
}