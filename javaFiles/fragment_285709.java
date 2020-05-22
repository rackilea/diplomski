mDollarsText.addTextChangedListener(new TextWatcher() {
        ...
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (mDollarsText.hasFocus()) {
                // show amount in yen
                if (s == null || s.length() == 0) {
                   mYenText.setText("0");
                } else { 
                   mYenText.setText(convertDollarsToYen(mDollarsText.getText().toString());
                }
            }
        }
        ...
    });

    mYenText.addTextChangedListener(new TextWatcher() {
        ...
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (mYenText.hasFocus()) {
                // show amount in dollars
                if (s == null || s.length() == 0) {
                   mDollarsText.setText("0");
                } else { 
                   mDollarsText.setText(convertYenToDollars(mYenText.getText().toString());
                }
            }
        }
        ...
    });