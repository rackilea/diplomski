public static String getTagValue(String tag, Element eElement) {
    System.out.println("Getting Tage Value for: " + tag);
    NodeList n1List = eElement.getElementsByTagName("field");
    for (int i = 0; i < n1List.getLength(); i++) {
        Node nNode = n1List.item(i);
        if (((Element) nNode).getAttribute("name").equalsIgnoreCase(tag)) {
            return nNode.getTextContent();
        }
    }
    return null;
}