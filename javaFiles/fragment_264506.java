int charactersLeft = 256;
final TextInputLayout postTextInputBase = findViewById(R.id.post_text_input_base);
final TextInputEditText postTextInput = findViewById(R.id.post_text_input);

postTextInput.addTextChangedListener(new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {           
        }

        @Override
        public void afterTextChanged(Editable s) {
           if (s.length() == 0) {
                postTextInputBase.setHint(null);
            }else {
                postTextInputBase.setHint((charactersLeft - s.length()) + " characters left");
            }
        }
    });