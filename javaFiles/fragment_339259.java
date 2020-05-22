import java.util.ArrayList;
import java.util.List;

public class ItemRegistry {
    private List<Item> items = new ArrayList<Item>();

    public ItemRegistry() {}

    void registerItem(Item i) {
        items.add(i);
    }

    double getTotalCost() {
        double total = 0.0;
        for(Item i : items)
            total += i.getCost();
        return total;
    }

    List<Item> getItems() {
        return items;
    }
}