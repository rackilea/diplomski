//Checks if either interest och year checkboxes are checked.
 if (checkBox.isChecked()) {
     double i = Double.parseDouble(interest.getText().toString())/100;
     button.setText(Double.toString(iKnowInterest(M, P, s, q, i)) + " years");
 } else {
     double n = Double.parseDouble(yearsToSave.getText().toString());
     button.setText(Double.toString(iKnowYears(M, P, s, q, n)) + " % per year");
 }