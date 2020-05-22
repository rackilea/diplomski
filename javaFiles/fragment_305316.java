NodeList itemNodes = doc.getElementsByTagName("item");
for (int i =0; i < itemNodes.getLength(); i++) {
    Element itemElement = (Element) itemNodes.item(i);
    String title = itemElement.getElementsByTagName("title").item(0).getTextContent();
    String description = itemElement.getElementsByTagName("description").item(0).getTextContent();

}