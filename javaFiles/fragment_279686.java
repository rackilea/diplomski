@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Info {

    @XmlElement(name = "item")
    private List<Item> getItems() {
        return new ArrayList<Item>(getMap().values());
    }

    private void setItems(final List<Item> items) {
        getMap().clear();
        for (Item item : items) {
            getMap().put(item.getKey(), item);
        }
    }

    public Map<Integer, Item> getMap() {
        if (map == null) {
            map = new HashMap<Integer, Item>();
        }
        return map;
    }

    private Map<Integer, Item> map;
}