public class Pizza {
    private double cost; // double is NOT a good idea for money

    public Pizza(double cost) { 
        if (cost < 0.0) throw new IllegalArgumentException("we won't pay you to take our pizza!");
        this.cost = cost; 
    }

    public double getCost() { return this.cost; }
}

public class ThinPizza extends Pizza {
    private static final double DEFAULT_COST = 2.0;

    public ThinPizza() { this(DEFAULT_COST); }
    public ThinPizza(double cost) { super(cost); }
}

public class ThickPizza extends Pizza {
    private static final double DEFAULT_COST = 5.0;

    public ThickPizza() { this(DEFAULT_COST); }
    public ThickPizza(double cost) { super(cost); }
}