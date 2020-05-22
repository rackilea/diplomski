private static double getDouble(EditText et) {
    if(et.getText().length() == 0) {
        return 0;
    }
    try {
        return Double.parseDouble(et.getText().toString());
    } catch (NumberFormatException e) {
        return 0; //default value for invalid entries?
                  //Or maybe show an error message?
    }
}