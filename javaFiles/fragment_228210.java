public static void main(String[] args) {
    ArrayList<Item> list = new ArrayList<Item>();
    list.add(new Item("foo", "bar"));
    list.add(new Item("Stuff", "Bla"));

    System.out.println(list);
}

public class Item {
    String a, b;

    public Item(String a, String b) {
        this.a = a;
        this.b = b;
    }
}