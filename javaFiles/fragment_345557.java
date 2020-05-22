@XmlElement(name = "Item", required = true, type = myNamespace.Item.class)
protected List<myNamespace.Item> items;

public List<myNamespace.Item> getItems() {
    if (items == null) {
        items = new ArrayList<myNamespace.Item>();
    }
    return this.items;
}