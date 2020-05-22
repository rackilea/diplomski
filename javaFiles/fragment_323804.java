@XmlRootElement
public class Wrapper<T> {

  private List<T> items;

  public Wrapper() {
    items = new ArrayList<T>();
  }

  public Wrapper(List<T> items) {
    this.items = items;
  }

  @XmlAnyElement(lax=true)
  public List<T> getItems() {
    return items;
  }
}