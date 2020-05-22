if (e.getSource() == up) {
    value100++;
    if (value100 > 0) {
        number.setText(value100 + "");
        down.setEnabled(true);
    }
}
//...
if (e.getSource() == up_3) {
    value100++;
    if (value100 > 0) {
        number_3.setText(value100 + "");
        down_3.setEnabled(true);
    }
}