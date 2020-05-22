private int getPrice(String productname, int quantity){
int price = 0;
switch(productName){       //Switch so you can find what item ordered and allocate the correct price
//Add cases for different items?
case "Sweater":
price = 10;
break;
default:
price = 0;
break;
}
    int totalPrice = price * quantity;  //Work out price by multiplying quantity of item by price determined by switch
return totalPrice;   
}