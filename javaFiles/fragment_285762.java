etOne = (EditText) findViewById(R.id.etSyst);
        etOne.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                int i = Integer.parseInt(s.toString());
                if (i >= 70 && i <= 190) {
                    sbSyst.setProgress( i - 70); // This ensures 0-120 value for seekbar
                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });