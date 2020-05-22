PhoneNumber.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        String text = charSequence.toString();
        if(!text.isEmpty()){
            sendVerification.setEnabled(true);
        }

    }

    @Override
    public void afterTextChanged(Editable editable) {


    }
});


sendVerification.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        if(!PhoneNumber.getText().toString().isEmpty()){
            number = PhoneNumber.getText().toString();

            PhoneNumber.setEnabled(false);
            PhoneProgress.setVisibility(View.VISIBLE);


            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                    number,
                    60,
                    TimeUnit.SECONDS,
                    PhoneAuthActivity.this,
                    mCallbacks
            );

        }
        else {
            Toast.makeText(PhoneAuthActivity.this, "Empty Field", Toast.LENGTH_SHORT).show();

        }
    }
});