private static String getNode(String tag, Element element) {

    NodeList nlList = element.getElementsByTagName(tag).item(0)
            .getChildNodes();

    Node nValue = (Node) nlList.item(0);

    return nValue.getNodeValue();

}