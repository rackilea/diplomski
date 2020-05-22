public void makeAPurchase(Purchase purchase){
    if (points > 2000)
        purchase.applyDiscount(0.05);
}

//Part of Purchase.java
public class Purchase {
    //...
    public void applyDiscount(double discountPercent) {
        price = price - (price * discountPercent);
    }
}