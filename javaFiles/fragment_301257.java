public class Product implements Serializable {
  // ....

  @Override
  public String toString() {
    return description + "/" + code + "/" + price + "/" + unit;
  }
}