@ManagedBean
@ViewScoped
public class Bean implements Serializable {

    private List<Item> items;
    private Item item;

    @PostConstruct
    public void init() {
        items = new ArrayList<>();
        items.add(new Item(1L, "one"));
        items.add(new Item(2L, "two"));
        items.add(new Item(3L, "three"));
    }

    public void submit() {
        System.out.println(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

}