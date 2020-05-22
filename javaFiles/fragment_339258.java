// Decorator class
public class ItemDiscount implements Item {
    private Item item;
    private double discount;

    public ItemDiscount(Item it, double amount) {
        item = it;
        discount = amount / 100.0; // e.g. 15/100 = 15%
    }

    @Override
    public String getName() {
        return item.getName();
    }

    @Override
    public double getCost() {
        return item.getCost() - (item.getCost() * discount);
    }
}