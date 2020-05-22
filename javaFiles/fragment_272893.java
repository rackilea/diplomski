private TextWatcher watcher;
......................................
inputSearchNama.addTextChangedListener(watcher);    //register watcher to edittext
inputSearchJenis.addTextChangedListener(watcher);   //register watcher to edittext
inputSearchMerk.addTextChangedListener(watcher);    //register watcher to edittext
watcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(inputSearchNama.getText().toString().trim().equals("")){
                //write your code here
            }
             if(inputSearchJenis.getText().toString().trim().equals("")){
                //write your code here
            }
            if(inputSearchMerk.getText().toString().trim().equals("")){
                //write your code here
            }

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                int after) {}

        @Override
        public void afterTextChanged(Editable s) {}
    };