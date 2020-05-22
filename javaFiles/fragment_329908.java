private static final boolean hasNextElementWithSameName(Node node) {
    String name = node.getNodeName();
    for (Node next = node.getNextSibling(); next != null; next = next.getNextSibling())
        if (next.getNodeType() == Node.ELEMENT_NODE) // only look at elements
            return next.getNodeName().equals(name); // stop on first element after "node"
    return false;
}
private static final int countPrevElementsWithSameName(Node node) {
    String name = node.getNodeName();
    int count = 0;
    for (Node prev = node.getPreviousSibling(); prev != null; prev = prev.getPreviousSibling())
        if (prev.getNodeType() == Node.ELEMENT_NODE) { // only look at elements
            if (! prev.getNodeName().equals(name))
                break; // stop when element name changes
            count++; // count elements of same name as "node"
        }
    return count;
}