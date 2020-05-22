private void addOperands() {
    double value_1, value_2;
    boolean good = true;
    try {
        value_1 = Double.parseDouble(tf_1.getText());   
    } catch (NumberFormatException e) {
        good = false;
        tf_1.setBackground(Color.red);
        tf_1.requestFocus();
    }
    try {
        value_2 = Double.parseDouble(tf_2.getText());
    } catch (Exception e) {
        good = false;
        tf_2.setBackground(Color.red);
        tf_2.requestFocus();
    }
    if(good)   
       tf_3.setText(String.valueOf(value_1 + value_2));
    else
       tf_3.setText("Bad input");   
}