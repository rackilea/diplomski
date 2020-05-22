public void operation(){
if(optr.equals("+")){
    result = op1 + op2;
    editText.setText("Result : " + Double.toString(result));
}
else if(optr.equals("-")){
    result = op1 - op2;
    editText.setText("Result : " + Double.toString(result));
}
else if(optr.equals("*")){
    result = op1 * op2;
    editText.setText("Result : " + Double.toString(result));
}
else if(optr.equals("/")){
    result = op1 / op2;
    editText.setText("Result : " + Double.toString(result));
}