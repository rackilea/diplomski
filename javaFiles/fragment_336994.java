editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editText1.isFocused()) {
                    String str = editText1.getText().toString().trim();
                    if (!str.isEmpty()) {
                        //your conversion logic here
                        editText2.setText(String.valueOf(convertedValue));
                    }else{
                        etTo.setText("0");
                    }
                }
            }
        });