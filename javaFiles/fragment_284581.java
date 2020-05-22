private double Doublify(EditText editText) {
    try {
        Double double = Double.parseDouble(editText.getText().toString());
    } catch (NumberFormatException e) {
        return 0;
    }
    return double;
}