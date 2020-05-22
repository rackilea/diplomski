final EditText editText = (EditText) findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {
            String sBackup;

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                double value;
                try {
                    if (editable.toString().equals("") == false) {
                        value = Double.valueOf(editable.toString().replace(',', '.'));
                        sBackup = editable.toString();
                    }
                } catch (Exception e) {
                    editText.setText(sBackup);
                    editText.setSelection(editText.getText().toString().length());
                }
            }
        });