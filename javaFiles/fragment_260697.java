private static final BigDecimal SMALL_DISCOUNT = new BigDecimal("0.05");
private static final BigDecimal LARGE_DISCOUNT = new BigDecimal("0.10");
private static BigDecimal getDiscountProportion(int quantity) {
    if (quantity < 0) {
        throw new IllegalArgumentException("Cannot purchase negative quantities");
    }
    return quantity < 2 ? BigDecimal.ZERO
        : quantity < 5 ? SMALL_DISCOUNT
        : LARGE_DISCOUNT;
}