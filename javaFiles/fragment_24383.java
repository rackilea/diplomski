Node rule = doc.getElementsByTagName("rule").item(0);

    // update IF attribute
    Node if=rule.getFirstChild();

    NamedNodeMap attr = if.getAttributes();
    Node nodeAttr = attr.getNamedItem("rightTerm");
    nodeAttr.setTextContent("20");