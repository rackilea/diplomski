@JsonDeserialize(using=ProductDeserializer.class)
public void setProducts(List<Product> value) {
   this.products = products;
}

@JsonDeserialize(using=OrderDeserializer.class)
public void setOrderss(List<Order> value) {
   this.orders = orders;
}