@Click(R.id.radioButtonEmail)
void radioButtonEmailClicked(View v) {
    if (radioButtonEmail.isChecked()) {
        editTextEmail.setText("");
    }
    else {
        editTextEmail.setText("TEST");
    }
}