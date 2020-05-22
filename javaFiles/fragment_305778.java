@JsonIgnoreProperties(unknown =true)
public class Customer {

@JsonProperty("id")
private String id;
@JsonProperty("products")
private List<Products> products;

public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

public List<Products> getProducts() {
    return products;
}

public void setProducts(List<Products> products) {
    this.products = products;
   }

}
 @JsonIgnoreProperties(unknown =true)
 class Products{
@JsonProperty("name")
private String name;
@JsonProperty("code")
private String code;
@JsonProperty("price")
private String price;

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getCode() {
    return code;
}

public void setCode(String code) {
    this.code = code;
}

public String getPrice() {
    return price;
}

public void setPrice(String price) {
    this.price = price;
   }

}