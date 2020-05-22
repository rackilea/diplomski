@ManagedBean
@SessionScoped
public class CartBean {

 private List<Product> products = new ArrayList<Product>();

 public void add(Product product) {
     products.add(product);
 }

 public void remove(Product product) {
     products.remove(product);
 }

 public List<Product> getProducts() {
     return products;
 }
}