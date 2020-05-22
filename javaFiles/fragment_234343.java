NodeList childNodes = elem.getChildNodes();
    int childCount = childNodes.getLength();
    Node childNode;
    for (int i = 0; i < childCount; i++) {
        childNode = childNodes.item(i);
        // do things with the node
    }