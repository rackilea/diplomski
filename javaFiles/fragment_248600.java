public abstract class AbstractProductList<T> extends AbstractList<T> {
  protected List<Product> data;

  public AbstractProductList(List<Product> data) {
    this.data = data;
  }

  protected abstract T getAttribute(Product product);

  public T get(int i) {
    return getAttribute(data.get(i));
  }

  public int size() {
    return data.size();
  }

  public T remove(int i) {
    return getAttribute(data.remove(i));
  }

  /* For better performance */
  public void clear() {
    data.clear();
  }

  /* Other operations unsupported */
}

public class ProductIdList extends AbstractProductList<Long> {
  public ProductIdList(List<Product> data) {
    super(data);
  }

  protected Long getAttribute(Product product) {
    return product.getId();
  }
}