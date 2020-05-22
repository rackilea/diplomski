public void onRadioButtonClicked(View view) {
    // Is the button now checked?
    boolean checked = ((RadioButton) view).isChecked();

    // Check which radio button was clicked
    switch(view.getId()) {
        case R.id.radio_pirates:
            if (checked)

i=1;
            break;
        case R.id.radio_ninjas:
            if (checked)

i=2;
            break;
    }
}