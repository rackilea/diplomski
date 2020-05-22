listener = (new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(count > 0){
                if(s.charAt(s.length()-1) == '.'){
                    Log.d("Sequence", "Noticed a \".\"");
                    CharSequence text = s.subSequence(0, s.length()-1);
                    Log.d("VIEW CLICKED:", String.valueOf(getCurrentFocus()));
                    setTextAndAdvance(getCurrentFocus(), text);
                } else {
                    Log.d("Sequence", "Noticed a \""+s+"\"");
                }
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    });