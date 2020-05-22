class Product {
    private DiscountStrategy discountStrategy;

    Product(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public int getDiscount() {
        return discountStrategy.getDiscount();
    }
}