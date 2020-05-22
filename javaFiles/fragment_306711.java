static interface BinaryOp {
   double calc(double arg1, double arg2);
}

private void applyBinaryOp(BinaryOp op) {
    Double value_1 = readDoubleOrHighlight(tf_1);
    Double value_2 = readDoubleOrHighlight(tf_2);
    if((value_1 != null) && (value_2 != null)) {
       double res = op.calc(value_1, value_2);
       tf_3.setText(res);
    }
    else
       tf_3.setText("Bad input");   
}