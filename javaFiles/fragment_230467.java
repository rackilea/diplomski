final String passwordText = getString(R.string.password);

//Show password on click
showBTN.setOnClickListener(new OnClickListener() {

    @Override
    public void onClick(View v) {
    //i want to use a string called from string.xml instead of hard coded
        resTXT.setText(passwordText + pass);
    }
});