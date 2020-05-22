// Class for your product and all related information...
public class Product {
    String name;
    double price;
    String color;
    double weight;

    public Product(String name, double price, String color, double weight){
        this.name = name;
        this.price = price;
        this.color = color;
        this.weight = weight;
    }
}

// Now add each Product to a HashMap (in your main class)...
HashMap<String,Product> products = new HashMap<String,Product>();
products.put("Cheese", new Product("Cheese",1.10,"Yellow",0.5);
products.put("Milk", new Product("Milk",2.0,"White",1.5);