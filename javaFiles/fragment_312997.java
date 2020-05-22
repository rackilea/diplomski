RadioGroup g = (RadioGroup) findViewById(R.id.rBtnDigits); 

// Returns an integer which represents the selected radio button's ID
int selected = g.getCheckedRadioButtonId();

// Gets a reference to our "selected" radio button
RadioButton b = (RadioButton) findViewById(selected);

// Now you can get the text or whatever you want from the "selected" radio button
b.getText();