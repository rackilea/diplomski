mCurrentPasswordEditText = (EditText) view.findViewById(R.id.current_password_edit_text);
mCurrentPasswordErrorTextView = (TextView) view.findViewById(R.id.current_password_error_text_view);
mCurrentPasswordEditText.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        //mCurrentPasswordErrorTextView.setText("");
    }
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //mCurrentPasswordErrorTextView.setText("");
    }
    @Override
    public void afterTextChanged(Editable s) {
        mCurrentPasswordErrorTextView.setText(" ");
    }
});