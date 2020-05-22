import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NewClass1 {

    static class Item {

        String a;

        public Item(String a) {
            this.a = a;
        }
        @Override
        public String toString() {
            return a;
        }
    }

    public static void main(String[] args) {
        List<Collection<Item>> hull = new ArrayList<Collection<Item>>();
        List<Item> seq = new ArrayList<Item>();
        Item it1 = new Item("item 1");
        seq.add(it1);
        hull.add(seq);
        List<Item> seq2 = new ArrayList<Item>();
        Item it2 = new Item("item 2");
        seq2.add(it2);
        hull.add(seq2);

        for (Collection<Item> current : hull) {
            for (Item item : current) {
                System.out.println(item);
            }
        }
    }
}