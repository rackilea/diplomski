final TextView preview = (TextView) findViewById(R.id.preview);
EditText input = (EditText) findViewById(R.id.input);
input.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        preview.setText(editable);
    }
});