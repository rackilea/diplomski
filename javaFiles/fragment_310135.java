NodeList list = object.getElementsByTagName("*");
    for (int i = 0; i < list.getLength(); i++) {
        Node listNode = nodeList.item(i);
        if (Node.ELEMENT_NODE == listNode.getNodeType()) {
            String nodeName = listNode.getNodeName();
            if (nodeName.equalsIgnoreCase("shape")
                    || nodeName.equalsIgnoreCase("Textbox")
                    || nodeName.equalsIgnoreCase("Button")) {

                Node node = findPropertyTagAndValue(listNode, "PropertyValue", "conditionContainer");
                if (node != null) {
                    System.out.println("Node Name = " + node.getNodeName() + "; Value = " + node.getTextContent());
                    DOMSource src = new DOMSource(list.item(i));
                    StringWriter sr = new StringWriter();
                    Result res = new StreamResult(sr);
                    tx.transform(src, res);
                    System.out.println(sr);
                }
            }
        }
    }


 /**
 * No Need to check for all those things. Only * will return all elements
 * including #text node. If you give proper node name then it will return
 * those node's only That's why there's node need for checking ELEMENT_NODE
 * in finding propertTags
 */

  public static Node findPropertyTagAndValue(Node node, String propertyTag, String propertyValue) {
    if (Node.ELEMENT_NODE == node.getNodeType()) {
        NodeList nodeList = ((Element) node).getElementsByTagName(propertyTag);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node listNode = nodeList.item(i);
            if (listNode.getTextContent().equalsIgnoreCase(propertyValue)) {
                return listNode;
            }
        }
    }
    return null;
}