public void onClick(View v) {
    int miles = Integer.parseInt(mileage.getText().toString());
    double litre = Double.parseDouble(litres.getText().toString());
    double answer = (double)miles / litre;

    result.setText((""+answer));
    ...