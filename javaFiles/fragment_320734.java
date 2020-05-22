public void onClick(View arg0) {
    try {
        double x1 = Double.parseDouble(editText1.getText().toString());
        double y1 = Double.parseDouble(editText2.getText().toString());
        double x2 = Double.parseDouble(editText3.getText().toString());
        double y2 = Double.parseDouble(editText4.getText().toString());
        double x3 = Double.parseDouble(editText5.getText().toString());
        double y3 = Double.parseDouble(editText6.getText().toString());
        double x4 = Double.parseDouble(editText7.getText().toString());
        double y4 = Double.parseDouble(editText8.getText().toString());

        //calculating distance
        double d1 = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1- y2, 2));
        double d2 = Math.sqrt(Math.pow(x3 - x4, 2) + Math.pow(y3- y4, 2));

        tvResult.setText(Double.toString(d1/d2));
    } catch (NumberFormatException e) {

    }
}