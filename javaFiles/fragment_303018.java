public int getFullPrice(Product product){
    int pricePerUnit = product.getPricePerUnit();
    int fullPrice = this.quantity * pricePerUnit;
    return fullPrice;
}

public int priceAfterDiscount(Product product){
    return getFullPrice(product) - this.discountRate;
}