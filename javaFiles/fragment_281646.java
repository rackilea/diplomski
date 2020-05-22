for (int i = 0; i < nodeList.getLength(); i++) {
    NodeList children = nodeList.item(i).getChildNodes();
    for (int j = 0; j < children.getLength(); j ++) {
        System.out.println(children.item(i).getAttributes().getNamedItem("qcode"));
    }
}