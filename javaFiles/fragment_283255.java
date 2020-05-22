public class Item {
    private final String name;
    private final double weight;

    public Item(String n, double w) {
        this.name = n;
        this.weight = w;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("%s %.3f", name, weight);
    }
}