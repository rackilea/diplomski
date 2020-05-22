TextWatcher textWatcher = new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        if (!TextUtils.isEmpty(edtOne.getText().toString().trim())
                || !TextUtils.isEmpty(edtTwo.getText().toString().trim())
                || !TextUtils.isEmpty(edtThree.getText().toString().trim())
                || !TextUtils.isEmpty(edtFour.getText().toString().trim())
                ) {


            int firtValue = TextUtils.isEmpty(edtOne.getText().toString().trim()) ? 0 : Integer.parseInt(edtOne.getText().toString().trim());
            int secondValue = TextUtils.isEmpty(edtTwo.getText().toString().trim()) ? 0 : Integer.parseInt(edtTwo.getText().toString().trim());
            int thirdValue = TextUtils.isEmpty(edtThree.getText().toString().trim()) ? 0 : Integer.parseInt(edtThree.getText().toString().trim());
            int forthValue = TextUtils.isEmpty(edtFour.getText().toString().trim()) ? 0 : Integer.parseInt(edtFour.getText().toString().trim());

            int answer = firtValue + secondValue + thirdValue + forthValue;

            Log.e("RESULT", String.valueOf(answer));
            tvResult.setText(String.valueOf(answer));
        }else {
            tvResult.setText("");
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
};