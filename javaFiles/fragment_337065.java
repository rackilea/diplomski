public class Item {
    private String name;
    private Type type;

    public Item() {
    }

    public Item(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}

public enum Type {
    STONE,
    GRASS
}

public class ItemComparator implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        String name1 = o1.getName();
        String name2 = o2.getName();

        Type type1 = o1.getType();
        Type type2 = o2.getType();

        int i = type1.name().compareTo(type2.name());
        if (i != 0) return i;

        i = name1.compareTo(name2);
        return i;
    }
}

public class Main {
    public static void main(String[] args) {
        Item item0 = new Item("StoneWhatever", Type.STONE);
        Item item1 = new Item("StoneSomethingElse", Type.STONE);
        Item item2 = new Item("StoneWhatever", Type.GRASS);
        Item item3 = new Item("GrassNameExampleHere", Type.GRASS);

        List<Item> itemList = new ArrayList<>();
        itemList.add(item0);
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);

        Collections.sort(itemList, new ItemComparator());
        for (Item item : itemList) {
            System.out.println(item);
        }
    }
}