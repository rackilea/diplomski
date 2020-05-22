private class MyTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
             // check for both edittexts if any of them is empty than disable the button
             btnCrAcc.setEnabled(!accName.getText().toString().trim().isEmpty() && !accMoney.getText().toString().trim().isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
   }