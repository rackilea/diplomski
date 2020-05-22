class Value{
    public int wholeNumber;
    public int decimalNumber;
}

private Value getWholeDecimalNumber(String s) {
    String[] arr = String.valueOf(s).split("\\.");
    Value value = new Value();
    value.wholeNumber = Integer.parseInt(arr[0]);
    if (arr.length > 1) {
        value.decimalNumber = Integer.parseInt(arr[1]);
    }
    return value;
}

public void onClick(View view) {
    String s = edW.getText().toString();
    Value value = getWholeDecimalNumber(s);
    int w= value.wholeNumber;
    int weight = w*40 + value.decimalNumber;
    int weightToDeduct = w*2;

    if (value.decimalNumber > 0) {
        if (value.decimalNumber > 20) {
            weightToDeduct += 2;
        }
        else {
            weightToDeduct += 1;
        }
   }
   txtV.setText("Total KGs: "+ (weight - weightToDeduct));