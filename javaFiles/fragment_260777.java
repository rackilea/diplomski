List<DiscountValue> ret = new ArrayList<>(values.size());
double[] tmp = { startPrice };
values.stream().forEachOrdered(v -> {
    DiscountValue discountValue = v.apply(quantity, tmp[0], digits, currencyIsoCode);
    tmp[0] -= discountValue.getAppliedValue();
    ret.add(discountValue);
});