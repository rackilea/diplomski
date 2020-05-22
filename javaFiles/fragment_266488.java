NamedNodeMap attrs = element.getAttributes();
for (int i = 0; i < attrs.getLength(); i++) {
    Attr attr = (Attr)attrs.item(i);
    String name = attr.getName();
    String value = attr.getValue();
    // use here
}