mEditText = (EditText)findViewById(R.id.edit_text);
mEditText.addTextChangedListener(new TextWatcher() {

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // Get changed text s here and use it 
    } 

});