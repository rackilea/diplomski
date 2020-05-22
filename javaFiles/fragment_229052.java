your_edittext.addTextChangedListener(new InputValidator());

    private class InputValidator implements TextWatcher {

        public void afterTextChanged(Editable s) {

        }    
        public void beforeTextChanged(CharSequence s, int start, int count,
                int after) {                

        }    
        public void onTextChanged(CharSequence s, int start, int before,
                int count) {

        }    
    }    
}