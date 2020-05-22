UserRatesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @SuppressLint("SetTextI18n")
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        if (position == 1) {
            SelectedSpin = ItemSelect.get(1);

        }
        else{
            UserRatesSpinner.setClickable(true);

        }
        if (position == 2) {
            SelectedSpin = ItemSelect.get(2);

        }
        else {
            UserRatesSpinner.setClickable(true);

        }
        if (position == 3) {
            SelectedSpin = ItemSelect.get(3);
        }
        else{
            UserRatesSpinner.setClickable(true);
        }

        if (LogHour.getText().toString().contains("Hours Logged")) {
            LogHour.setText("Log Hours");
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
});