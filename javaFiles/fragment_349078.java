private Set<Price> priceList = new HashSet<Price>();
...
public void updatePrice(Price price) {
price.setId(null);// Hibernate will execute an INSERT statement

price.setProduct(this);
priceList.add(price);
}