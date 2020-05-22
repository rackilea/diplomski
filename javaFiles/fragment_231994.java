// within mouse listener
if (xTurn) {
    label.setForeground(X_COLOR);
    label.setText("X");
} else {
    label.setForeground(O_COLOR);
    label.setText("O");
}
// toggle value held by boolean variable.
xTurn = !xTurn;