private List<Product> products;

public List<Product> getProducts() {
    if (products == null) {
        products = new ArrayList<Product>();
        products.add(new Product("Tennis Racket"));
        products.add(new Product("Baseball Bat"));
        products.add(new Product("Hockey Stick"));
    }
    return products;
}