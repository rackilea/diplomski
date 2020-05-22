public void onRadioButtonClicked(View view) {
// Is the button now checked?
boolean checked = ((RadioButton) view).isChecked();

// Check which radio button was clicked
switch(view.getId()) {
    case R.id.radioButton1:
        if (checked)
            // RadioButton id 1
        break;
    case R.id.radioButton2:
        if (checked)
            //RadioButton id 2
        break;
}