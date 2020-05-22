NodeList entityNodeList = xmlDoc.getDocumentElement().getElementsByTagName("entity");

for(int i = 0; i < entityNodeList.getLength(); ++i) {
    String name = null;
    int id = 0;
    // Read all fields in the entity
    Element entity = (Element) entityNodeList.item(i);
    NodeList entityFields = entity.getElementsByTagName("field");
    for (int j = 0; j < entityFields.getLength(); ++j) {
        Node fieldNode = entityFields.item(j);
        Node dAttribute = fieldNode.getAttributes().getNamedItem("name");
        String attributeName = dAttribute.getNodeValue();
        System.out.println(attributeName);
        if (attributeName.equals("id")) {
            id = Integer.parseInt(fieldNode.getAttributes().getNamedItem("value").getNodeValue());
        }
        if (attributeName.equals("name")) {
            name = fieldNode.getAttributes().getNamedItem("value").getNodeValue();
        }

    }
    System.out.println("name=" + name + ", id=" + id);