public class MyObjectClass {
private int quantity;

private String id;
private String brand;
private String category;
private String description;
private String code;
private String price;

public MyObjectClass(int quantity, String id, String brand, String category, String description, String code, String price) {
    this.quantity = quantity;
    this.id = id;
    this.brand = brand;
    this.category = category;
    this.description = description;
    this.code = code;
    this.price = price;
}

public int getQuantity() {
    return quantity;
}

public void setQuantity(int quantity) {
    this.quantity = quantity;
}

public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

public String getBrand() {
    return brand;
}

public void setBrand(String brand) {
    this.brand = brand;
}

public String getCategory() {
    return category;
}

public void setCategory(String category) {
    this.category = category;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
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