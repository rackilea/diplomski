public class Product {

    private String name, model;
    private Double price;

    public Product(String name, String model, Double price) {
        this.name = name;
        this.model = model;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public Double getCost() {
        return price;
    }
}