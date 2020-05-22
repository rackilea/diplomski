for (HtmlListItem node: nodes) {
    NodeList children = node.getChildNodes();
    for (int i = 0; i < children.getLength(); i++) {
       Node child = children.item(i);
       /** extract data from child **/
    }       
}