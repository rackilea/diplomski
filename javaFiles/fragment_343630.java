public class Product {
    private String name;
    private double price;
    private int    qty;
    public Product(String name, double price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }
    public String getName() {
        return this.name;
    }
    public double getPrice() {
        return this.price;
    }
    public int getQty() {
        return this.qty;
    }
}