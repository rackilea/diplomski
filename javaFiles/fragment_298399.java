public class HMTest {

    public static void main(String[] args) {

        int totalWeight = 0;
        HashMap<String, Item> map = new HashMap<String, Item>();
        map.put("Key1", new Item(10));
        map.put("Key2", new Item(20));
        map.put("Key3", new Item(30));

        Collection<Item> values = map.values();

        for (Item i : values) {
            totalWeight += i.getWeight();
        }

        System.out.println("Total Weight :" + totalWeight);

    }

}

class Item {
    private int weight;

    public Item(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}