public class ElementInfo {

    private String name;
    private String symbol;
    private double mass;

    public String get_name() { return name; }
    public String get_symbol() { return symbol; }
    public double get_mass() { return mass; }

    public ElementInfo(name, symbol, mass) {
        this.name = name;
        this.symbol = symbol;
        this.mass = mass;
    }
}