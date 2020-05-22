if (e.getSource() == down) {
    value1000--;
    if (value1000 > 0) {
        number.setText(value1000 + "");
    }
    if (value1000 == 0) {
        number.setText(value1000 + "");
        down.setEnabled(false);
        value1000 = 0;
    }
}
//...
if (e.getSource() == down_3) {
    value100--;
    if (value100 > 0) {
        number_3.setText(value100 + "");
    }
    if (value100 == 0) {
        number_3.setText(value100 + "");
        down_3.setEnabled(false);
        value100 = 0;
    }
}