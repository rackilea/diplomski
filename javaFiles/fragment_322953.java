public void addandclear(){
    String val = firstValue.getText().toString();
    try {
        firstNum = new BigDecimal(val);
        EditText edttxt1 = (EditText) findViewById(R.id.edttxt1);
        edttxt1.setText("");
    } catch (NumberFormatException e) {
        if (val.length() == 0) {
            // blank field
        } else {
            // something wrong with the input
        }
    }
}