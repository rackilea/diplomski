public class Order {

//Constructor 2
public Order(String productName, int quantity) {
this.productName = productName;//Get the name
this.quantity = testQuantity(quantity); //Get the total quantity
this.orderPrice =getPrice(productName, quantity);  //Get the price of the order
this.discountPrice = 0; //Should be set to a value, even though it won't be used in this    constructor
orderNum++;  //Another order in, up the count :)
displayOrder(productName, quantity, this.orderPrice, this.discountPrice);  //Show order details
}

//Constructor 3
public Order(String productName, int quantity, int discount) {
this.productName = productName; //Get the name
this.quantity = testQuantity(quantity); //Get the total quantity
this.orderPrice = getPrice(productName, quantity);  //Get the price of the order
this.discountPrice = testDiscount(discount, this.orderPrice); //Get the price if there is a discount

orderNum++; //Another order in, up the count :)
displayOrder(productName, quantity, this.orderPrice, this.discountPrice); //Show order details
}