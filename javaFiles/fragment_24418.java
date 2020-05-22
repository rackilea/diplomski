@JsonIgnoreProperties(ignoreUnknown = true)
class Product {

  private Integer id;
  private String productSku;
  private String productInventory;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getProductSku() {
    return productSku;
  }

  public void setProductSku(String productSku) {
    this.productSku = productSku;
  }

  public String getProductInventory() {
    return productInventory;
  }

  public void setProductInventory(String productInventory) {
    this.productInventory = productInventory;
  }
}

class Products{

  private List<Product> products;

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }
}

public class Main{

  public static void main(String[] args) throws Exception{
    String jsonString =
        "{\n"
            + "  \"products\": [\n"
            + "    {\n"
            + "      \"id\": 1,\n"
            + "      \"productSku\": \"123\",\n"
            + "      \"productInventory\": \"24\"\n"
            + "    },\n"
            + "    {\n"
            + "      \"id\": 2,\n"
            + "      \"productSku\": \"12350\",\n"
            + "      \"productInventory\": \"22\"\n"
            + "    },\n"
            + "    {\n"
            + "      \"id\": 3,\n"
            + "      \"productSku\": \"12351\",\n"
            + "      \"productInventory\": \"19\"\n"
            + "    }\n"
            + "  ]\n"
            + "}";

    ObjectMapper mapper = new ObjectMapper();
    Products products = mapper.readValue(jsonString, Products.class);
    // To just access list of ids
    List<Product> productsList= products.getProducts();
    List<Integer> productIds = new ArrayList<>();
    for(Product product : productsList){
      productIds.add(product.getId());
    }
    System.out.println(productIds);
    }
}