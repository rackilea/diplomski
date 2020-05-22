JCheckBox toppings[] = new JCheckBox[] {
    olivCheckBox,
    mushCheckBox,
    pineapCheckBox,
    capsiCheckBox
};
topPrice = 0;
for (JCheckBox topping : toppings) {
    if (topping.isSelected()) {
        topPrice += 0.50;
    }
}