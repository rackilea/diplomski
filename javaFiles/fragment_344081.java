public void onRadioButtonClicked(View view) {
    // Is the button now checked?
    boolean checked = ((RadioButton) view).isChecked();

    // Check which radio button was clicked
    switch(view.getId()) {
        case R.id.imperial:
            if (checked)
                EditBox1.setVisibility(Visible)
            break;
        case R.id.metrics:
            if (checked){
                EditBox1.setVisibility(Visible)
                EditBox2.setVisibility(Visible) 
            }
            break;
    }
}