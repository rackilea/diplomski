public class RegularItem implements Item {
    private String name;
    private double cost;

    public RegularItem(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getCost() {
        return cost;
    }
}