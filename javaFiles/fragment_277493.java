private String productName; //Name of product
private int quantity;       //Quantity ordered
private int orderPrice;     // The total order of the price
private int discountPrice;  //Somewhere to store the price of an order with a discount
private static int orderNum; //This is static so that you it can be referenced even if no orders     have been made 


public static void main(String[] args){ //Test the ordering
Order order1 = new Order("Sweater", 2);
Order order2 = new Order("Sweater", 2, 5);
}