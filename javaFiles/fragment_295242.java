public class Record implements Comparable<Record> {
    public static Record parse(String[] ss) {
        // TODO: implement some basic parsing
    }

    private String name;
    private int quantity;
    private BigDecimal cost, price;

    private Record() {}

    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public BigDecimal getCost() { return cost; }
    public BigDecimal getPrice() { return price; }

    public int compareTo(Record other) {
        return this.name.compareTo(other.name);
    }

    public String toString() {
        return name;
    }
}