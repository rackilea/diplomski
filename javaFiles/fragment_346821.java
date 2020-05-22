mCodeFourEt.setOnEditorActionListener(new EditText.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                mConfirmBtn.performClick();
                return true;
            }
            return false;
        }


    });


    mCodeTwoEt.setOnKeyListener(new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_DEL) {
                String text = mCodeTwoEt.getText().toString();
                if (text.length() == 0) {
                    mCodeOneEt.requestFocus();
                    mCodeOneEt.selectAll();
                    return true;
                }
            }

            return false;
        }
    });

    mCodeThreeEt.setOnKeyListener(new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_DEL) {
                String text = mCodeThreeEt.getText().toString();
                if (text.length() == 0) {
                    mCodeTwoEt.requestFocus();
                    mCodeTwoEt.selectAll();
                    return true;
                }
            }

            return false;
        }
    });

    mCodeFourEt.setOnKeyListener(new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_DEL) {
                String text = mCodeFourEt.getText().toString();
                if (text.length() == 0) {
                    mCodeThreeEt.requestFocus();
                    mCodeThreeEt.selectAll();
                    return true;
                }

            }

            return false;
        }
    });

    mCodeOneEt.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (mCodeOneEt.getText().toString().length() > 0) {
                mCodeTwoEt.requestFocus();
            }

        }
    });

    mCodeTwoEt.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (mCodeTwoEt.getText().toString().length() > 0) {
                mCodeThreeEt.requestFocus();
            }

        }
    });

    mCodeThreeEt.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (mCodeThreeEt.getText().toString().length() > 0) {
                mCodeFourEt.requestFocus();
            }

        }
    });

    mCodeFourEt.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    });