private static int tID=0;
private int orderId;
private String itemName;

public Order(String itemName){
    tID++;
    this.orderId = tID; //use this.orderId in the rest of Order's functions
    this.itemName = itemName;

}