public void setAnswerText(double num1, double num2, DoubleBinaryOperator operator){
    final double ans = operator.applyAsDouble(num1, num2);
    final double doub = Math.round(ans * 100000.0) / 100000.0;
    if(doub == (int) ans){
        Answer.setText(Integer.toString((int) ans));
    } else{
        Answer.setText(Double.toString(doub));
    }
}