public double getCartTotal() {
    double totalPrice = 0.0;
    for(Product p: cart) {
        totalPrice += p.getProductPrice();
    }
    return totalPrice;
}