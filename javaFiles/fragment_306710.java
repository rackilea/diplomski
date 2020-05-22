private Double readDoubleOrHighlight(JTextField tf) {
    try {
        double res = Double.parseDouble(tf.getText());   
        tf.setBackground(whatever-default-background-is);
        return res;
    } catch (NumberFormatException e) {
        tf.setBackground(Color.red);
        tf.requestFocus();
        return null;
    }
}

private void addOperands() {
    Double value_1 = readDoubleOrHighlight(tf_1);
    Double value_2 = readDoubleOrHighlight(tf_2);
    if((value_1 != null) && (value_2 != null))
       tf_3.setText(String.valueOf(value_1 + value_2));
    else
       tf_3.setText("Bad input");   
}