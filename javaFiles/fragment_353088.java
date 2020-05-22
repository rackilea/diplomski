public void plus(View view) {
    int a = 0;
    int b = 0;

    try {
        a = Integer.parseInt(num1.getText().toString().trim());
    } catch (NumberFormatException e) { }

    try {
        b = Integer.parseInt(num2.getText().toString().trim());
    } catch (NumberFormatException e) { }

    int sum2 = a + b;

    result.setText("" + sum2);
}