AutoCompleteTextView activeET;
activeET = mFromAddress;  // set mFromAddress as active text in start

mFromAddress.setOnFocusChangeListener(new View.OnFocusChangeListener() {
    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        if(hasFocus)
            activeET = mFromAddress;
    }
});

mToAddress.setOnFocusChangeListener(new View.OnFocusChangeListener() {
    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        if(hasFocus)
            activeET = mToAddress;
    }
});