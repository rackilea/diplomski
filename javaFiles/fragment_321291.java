public interface Product {
    double getPrice();
}

class ProductA implements Product {
    public double getPrice() {
        // implementation
    }
}

// ...same for ProductB

public class GeneralProduct {
    String label;
    Product product;
    public GeneralProduct(String label, Product product)
    {
        this.label = label;
        this.product = product;
    }

    // You might have something like this, or not
    public double getProductPrice() {
        return this.product.getPrice();
    }
}

// Then using it:
auxList.add("ProductA", new ProcuctA("ProductA"));
auxList.add("ProductB", new ProcuctB("ProductB"));