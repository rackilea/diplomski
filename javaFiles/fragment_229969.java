NodeList nodes = elSVG.getElementsByTagName("g");
    Node node = nodes.item(0);
    Element el = null;
    if(Node.ELEMENT_NODE == node.getNodeType()) {
        el = (Element)node;
    }