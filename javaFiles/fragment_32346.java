@ManagedBean(name = "cart")
@SessionScoped
public class CartBean {

  private List<String> items;

  public CartBean() {
    items = new ArrayList<>();
    items.add("shirt");
    items.add("skirt");
    items.add("trouser");
  }

  public List<String> getItems() {
    return items;
  }

}