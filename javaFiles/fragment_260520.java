private void onEqual() {
    [...]
    String txt = txtScreen.getText().toString();
    double result = evalLeftToRight(txt);
    txtScreen.setText(Double.toString(result));
    [...]
}