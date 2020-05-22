/**
 * Optional interface for uniting anything that can be valued.
 */
public interface Valuable {
  double getValue();
}

/**
 * Company definition.  A company's value is assessed by summing
 * the value of each of its constituent Stores.
 */
public class Company implements Valuable {
  private final Set<Store> stores = new HashSet<Store>();

  public void addStore(Store store) {
    this.stores.add(store);
  }

  public void removeStore(Store store) {
    this.stores.remove(store);
  }

  public double getValue() {
    double ret = 0.0;

    for (Store store : stores) {
      ret += store.getValue();
    }

    return ret;
  }
}

/**
 * Store definition.  A store's value is the sum of the Products contained within it.
 */
public class Store implements Valuable {
  private final List<Product> products = new LinkedList<Product>();

  public void addProduct(Product product) {
    this.products.add(product);
  }

  public void removeProduct(Product product) {
    this.products.remove(product);
  }

  public double getValue() {
    double ret = 0.0;

    for (Product product : products) {
      ret += product.getValue();
    }

    return ret;
  }
}

/**
 * Product definition.  A product has a fixed inherent value.  However, you could
 * always model a product to depreciate in value over time based on a shelf-life, etc.
 * In this case you might wish to change the Valuable interface to accept a parameter;
 * e.g. depreciationStrategy.
 */
public class Product implements Valuable {
  private final double value;

  public Product(double value) {
    this.value = value;
  }

  public double getValue() {
    return value;
  }
}