public static final DISCOUNT_FOR_REPEAT_CUSTOMERS = 0.05;
public void makeAPurchase(Purchase purchase){
    if (customerCanGetDiscount())
        purchase.applyDiscount(DISCOUNT_FOR_REPEAT_CUSTOMERS);
}

private boolean customerCanGetDiscount() {
    return points > 2000;
}