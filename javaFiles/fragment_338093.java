public static List<Element> elements(Node parent) {
    List<Element> result = new LinkedList<Element>();
    NodeList nl = parent.getChildNodes();
    for (int i = 0; i < nl.getLength(); ++i) {
        if (nl.item(i).getNodeType() == Node.ELEMENT_NODE)
            result.add((Element) nl.item(i));
    }
    return result;
}