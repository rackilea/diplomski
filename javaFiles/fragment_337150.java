@XStreamAlias("Groups")
public class GroupData {
    @XStreamAlias("Products")
    private List<Product> products = new ArrayList<>();

    @XStreamAlias("OtherProducts")
    private List<OtherProduct> otherProducts = new ArrayList<>();

    public void add(Product product) {
        getProducts().add(product);
    }

    public void add(OtherProduct otherProduct) {
        getOtherProducts().add(otherProduct);
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<OtherProduct> getOtherProducts() {
        return otherProducts;
    }

}