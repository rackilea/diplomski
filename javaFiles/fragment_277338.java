private List<Item> items;

@XmlElementWrapper(name="items")
@XmlElement(name="item")
public List<Item> getItems() {
    return items;
}