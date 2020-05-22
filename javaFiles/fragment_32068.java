public void startCalculation() {
    RadioGroup rg = (RadioGroup)findViewById(R.id.radioGroup);
    int selectedConversion = rg.getCheckedRadioButtonId();
    String lInputString = ((EditText) findViewById(R.id.currentSpeed)).getText().toString();
    double input = 0;
    if (!lInputString.trim().equals("")){
      input = Double.parseDouble(lInputString);
    }
    double speed = 0;
    String measurement = "";
    System.out.println("The Value of Input is: " + input);

    //If its 0 then no unit has been selected
    if(selectedConversion != -1 && input > 0) {