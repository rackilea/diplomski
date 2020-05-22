final NodeList collection = root.getElementsByTagName("collection");
for (int i = 0; i < collection.getLength(); i++) {

    Node node = collection.item(i);
    if (!(node instanceof com.google.gwt.xml.client.Element)) {
        continue;
    }

    com.google.gwt.xml.client.Element coll =
    (com.google.gwt.xml.client.Element)node;
    RootPanel.get("slot2").add(new Label("coll: "));
}