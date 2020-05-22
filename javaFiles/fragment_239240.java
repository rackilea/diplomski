EditText myTxt = ...;
EditText myTxt2 = ...;
EditText result = ...;

TextWatcher w = new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void afterTextChanged(Editable editable) {
        if("Cannot Divide By Zero".equals(result.getText().toString())){// the "result" contains the error message
            if(editable.matches("^\\-?\\d+$")){// the `EditText` contain a number (can be a negative number).
                result.setText("");// clear the error message.
            }
        }
    }
};

myTxt.addTextChangedListener(w);
myTxt2.addTextChangedListener(w);