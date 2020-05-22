public class ProductControllerImplMock implements ProductController {
    List<Product> products;

    public ProductControllerImplMock() {
        products = new ArrayList<Product>();
    }

    public List<Product> listProducts() {
        products.add(new Product("A"));
        products.add(new Product("B"));
        return products;
    }

    public List<Product> listProducts(NameFilter nameFilter) {
        products.add(new Product("A"));
        return products;
    }
}