public abstract class GeneralProduct {
    String label;
    public GeneralProduct(String label)
    {
        this.label = label;
    }

    public abstract double getPrice();
}

class ProductA extends GeneralProduct {
    @Override
    public double getPrice() {
        // implementation
    }
}

// and the same for ProductB