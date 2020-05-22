private void displayOrder(String productName, int quantity, int orderPrice, int discountPrice){
if(discountPrice == 0){    //If the discount is 0 then there is no discount so the discount price is the same as the order price
    discountPrice = orderPrice;
}
// \n is called an escape character and when in a string creates a new line.
System.out.println("You have ordered: " + quantity + " " + productName + ("(s)")   //Number and name of item ordered
        + "\nTotal cost:  £" + orderPrice + "\nPrice with Discount (If applicable)=  £" +  discountPrice  //Order price and discount price displayed
        + "\nOrder number: " + orderNum +"\n"); //Order Number
}