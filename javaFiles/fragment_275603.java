final LinearLayout rootLayout = ...;

// within your loop
et.addTextChangedListener(new TextWatcher() {
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
});