public class Products_Main
{
  @SerializedName("current_page")
  int current_page;

  @SerializedName("data")
  private List<Product> products;

  public int getCurrent_page() {
    return current_page;
  }

  public void setCurrent_page(int current_page) {
    this.current_page = current_page;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }
}