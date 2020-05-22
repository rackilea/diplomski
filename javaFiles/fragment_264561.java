class Foo {
 private String name;
 private TreeSet<Item> items;

 public Foo(String name) {
    this.name = name;
    items = new TreeSet<Item>();
 }
 public String getName() { return name; }
 public void setName(String name) {this.name = name;}
 public TreeSet<Item> getItems() {return items; }
 public void addItem(Integer id, Integer value) {
    items.add(new Item(id, value));
 }

 public class Item implements Comparable {
    @Override
    public int compareTo(Object arg0) {
        Item i = (Item) arg0;
        if (id == i.id)
            return 0;
        else if (id > i.id)
            return 1;
        else
            return -1;
    }

    private Integer id;
    private Integer value;

    public Item(Integer id, Integer value) {
        this.id = id;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}