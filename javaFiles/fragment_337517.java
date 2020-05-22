public class TestFlexJson {
  public static void main(String args[]) {
    ProductInfo p1 = new ProductInfo(1, "Stack");
    ProductInfo p2 = new ProductInfo(2, "Overflow");
    List<ProductInfo> infos = Arrays.asList(p1, p2);
    String s = new JSONSerializer()
        .exclude("*.class", "description")
        //.include("productId", "name")
        // EDIT: the "include" call is irrelevant for this example.
        .serialize(infos);
    System.out.println(s);
    // => [{"name":"Stack","productId":1},{"name":"Overflow","productId":2}]
    List<ProductInfo> ls = new JSONDeserializer<List<ProductInfo>>().deserialize(s);
    System.out.println(ls);
    // => [{name=Stack, productId=1}, {name=Overflow, productId=2}]
  }
  public static class ProductInfo {
    private int id;
    private String name;
    private String desc; // Not used, to demonstrate "exclude".
    public ProductInfo(int id, String name) {
      this.id = id;
      this.name = name;
    }
    public int getProductId() { return this.id; }
    public String getName() { return this.name; }
    public String getDescription() { return this.desc; }
  }
}