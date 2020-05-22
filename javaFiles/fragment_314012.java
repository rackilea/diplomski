for (int i = 0; i < 10; i++) {
    if (clicked == digits[i]) {
        int lastValue = i;
        return;
    }
}
if (clicked == clearEntry) {
    expr.setText(expr.getText() - lastValue);
    return;
    // do something
}