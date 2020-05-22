Element parent = ... ;

String childName = "texture";
NodeList childs = parent.getChildNodes();

for (int nodeIx = 0; nodeIx < childs.getLength(); nodeIx++) {
    Node node = childs.item(nodeIx);

    if (node.getNodeType() == Node.ELEMENT_NODE 
            && node.getNodeName().equals(name)) {
        // cool stuff here
    }
}