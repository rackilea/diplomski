List<Node> list = XmlUtil.asList(element.getChildNodes());
list = list.subList(
    list.indexOf(element.getOwnerDocument().getElementById("value5"))+1, list.size());

Stream<Element> stream = list.stream()
    .filter(Element.class::isInstance).map(Element.class::cast);