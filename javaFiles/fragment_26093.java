-----------------------------------test.Order.java-----------------------------------

package test;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order {

@SerializedName("product_id")
@Expose
private String productId;
@SerializedName("qty")
@Expose
private String qty;
@SerializedName("price")
@Expose
private String price;
@SerializedName("total")
@Expose
private String total;
@SerializedName("product_name")
@Expose
private String productName;

public String getProductId() {
return productId;
}

public void setProductId(String productId) {
this.productId = productId;
}

public String getQty() {
return qty;
}

public void setQty(String qty) {
this.qty = qty;
}

public String getPrice() {
return price;
}

public void setPrice(String price) {
this.price = price;
}

public String getTotal() {
return total;
}

public void setTotal(String total) {
this.total = total;
}

public String getProductName() {
return productName;
}

public void setProductName(String productName) {
this.productName = productName;
}

}
-----------------------------------test.TestClass.java-----------------------------------

package test;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestClass {

@SerializedName("user_id")
@Expose
private String userId;
@SerializedName("username")
@Expose
private String username;
@SerializedName("order")
@Expose
private List<Order> order = null;

public String getUserId() {
return userId;
}

public void setUserId(String userId) {
this.userId = userId;
}

public String getUsername() {
return username;
}

public void setUsername(String username) {
this.username = username;
}

public List<Order> getOrder() {
return order;
}

public void setOrder(List<Order> order) {
this.order = order;
}

}