public class Product {
    String name;
    String Seller;
    double price;
    int quantity;

    public Product(String name, double price, int quantity, String seller){
        this.name = name;
        this.seller = seller;
        this.price = price;
        this.seller = seller;
    }

    public String toString(){
        double total = p.price * p.quantity;
        return name + "\t" + price + "\t" quantity + "\t" + seller + "\t" + total;
    }
}