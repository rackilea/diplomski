btnSubmit.setClickable(false);

    edtText.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if(s.toString().length() == 0){
                btnSubmit.setClickable(false);
            }
            else
            {
                //Validate if its Alphabets only - if returned true,
                boolean value = validateAlphabetsOnly(s.toString());
                if(value)
                {
                    btnSubmit.setClickable(true);
                }
            }
        }
    });