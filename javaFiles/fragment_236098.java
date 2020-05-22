public void tempConverterClick(View view) {
    switch (view.getId()) {
    case R.id.button1:
        RadioButton celsiusButton = (RadioButton) findViewById(R.id.radio0);
        RadioButton fahrenheitButton = (RadioButton) findViewById(R.id.radio1);
        if (text.getText().length() == 0) {
            Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_LONG).show();
            return;
        }
        float inputValue = Float.parseFloat(text.getText().toString());
        if (celsiusButton.isChecked()) {
            text.setText(String.valueOf(convertFahrenheitToCelsius(inputValue)));
            celsiusButton.setChecked(false);
            fahrenheitButton.setChecked(true);
        }
        else {
            text.setText(String.valueOf(convertCelsiusToFahrenheit(inputValue)));
            fahrenheitButton.setChecked(false);
            celsiusButton.setChecked(true);
        }
        break;
    }
}