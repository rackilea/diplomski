NodeList nodes = doc.getElementsByTagName(elementName);
Set<Element> targetElements = new HashSet<Element>();

for (int i = 0; i < nodes.getLength(); i++) {
    Element e = (Element)nodes.item(i);
    targetElements.add(e);
}
for (Element e: targetElements) {
    e.getParentNode().removeChild(e);
}