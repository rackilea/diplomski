NodeFilter leafElements = new NodeFilter() {
    @Override
    public short acceptNode(Node node) {
        for (Node child = node.getFirstChild(); child != null; child = child.getNextSibling())
            if (child.getNodeType() == Node.ELEMENT_NODE)
                return NodeFilter.FILTER_SKIP;
        return NodeFilter.FILTER_ACCEPT;
    }
};
TreeWalker walker = ((DocumentTraversal)document).createTreeWalker(document.getDocumentElement(),
                                                                   NodeFilter.SHOW_ELEMENT,
                                                                   leafElements,
                                                                   false);
for (Element leaf; (leaf = (Element)walker.nextNode()) != null; ) {
    Deque<String> path = new ArrayDeque<>();
    for (Node node = leaf; node.getNodeType() == Node.ELEMENT_NODE; node = node.getParentNode())
        path.addFirst(((Element)node).getAttribute("id"));
    System.out.println(path);
}