int quantity = ...; // Wherever you get this from
BigDecimal discountProportion = getDiscountProportion(quantity);
BigDecimal originalPrice = new BigDecimal(quantity).multiply(new BigDecimal(20000));
BigDecimal discount = originalPrice.multiply(discountProportion);
// TODO: Rounding
if (discount.equals(BigDecimal.ZERO)) {
    System.out.println("No discount applied");
} else {
    System.out.println("Discount: " + discount);
}
BigDecimal finalCost = originalPrice.subtract(discount);