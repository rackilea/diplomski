public class OrderService {
    private PriceHelper priceHelper = new PriceHelper();

    public double calculateOrderPrice(order) {
        double price = 0;
        for (Item item : order.getItems()) {
            double += priceHelper.calculatePrice(item.getProduct());
        }
    }
}

public class ProductService {
    private PriceHelper priceHelper = new PriceHelper();

    public double getProductPrice(Product product) {
        return priceHelper.calculatePrice(product);
    }
}