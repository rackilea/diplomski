mEditText = (EditText)findViewById(R.id.ET);
mEditText.addTextChangedListener(mTextWatcher);
TextWatcher mTextWatcher = new TextWatcher() {
        private CharSequence temp;
        @Override
        public void beforeTextChanged(CharSequence s, int arg1, int arg2,
                int arg3) {
            temp = s;
        }
        @Override
        public void onTextChanged(CharSequence s, int arg1, int arg2,
                int arg3) {
        }
        @Override
        public void afterTextChanged(Editable s) {
         //CHECK HERE if answer is valid or not
        }
    };