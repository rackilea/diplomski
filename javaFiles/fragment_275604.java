final LinearLayout rootLayout = ...;

// again, within your loop
TextWatcher textWatcher = new TextWatcher() {
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void afterTextChanged(final Editable s) {
        for (int i = 0; i < rootLayout.getChildCount(); i++) {
            View view = rootLayout.getChildAt(i);

            if (view instanceof EditText && view != et) {
                ((EditText) view).setText(s.toString());
            }
        }
    }
};

et.setOnFocusChangeListener(new OnFocusChangeListener() {
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
             ((EditText) view).addTextChangedListener(textWatcher);
        } else {
             ((EditText) view).removeTextChangedListener(textWatcher);
        }
    }
});