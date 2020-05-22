for (int i = 0; i < 4; i++) {
    if (clicked == oplabels[i]) {
        expr.setText(expr.getText + oplabels[i]);
        return;
    }
    // tack on that operator to the expr string
}