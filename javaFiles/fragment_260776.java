List<DiscountValue> ret = new ArrayList<>(values.size());
double tmp = startPrice;
for (DiscountValue value : values) {
    DiscountValue discountValue = value.apply(quantity, tmp, digits, currencyIsoCode);
    tmp -= discountValue.getAppliedValue();
    ret.add(discountValue);
}