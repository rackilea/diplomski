class PricePair {
    JCheckBox jCheckBox;
    BigDecimal price;
}

BigDecimal total = new BigDecimal("0.00");

for(PricePair option : options) {
    if(option.jCheckBox.isSelected()) {
        total = total.add(option.price);
    }
}