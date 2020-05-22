EditText et_auto_complete_edit_text;
 et_auto_complete_edit_text = findViewById(R.id.et_auto_complete_edit_text);
 et_auto_complete_edit_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
               s.toString()
            }
        });