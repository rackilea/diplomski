textView.addTextChangedListener(new TextWatcher(){
    public void afterTextChanged(Editable s) {}
    public void beforeTextChanged(CharSequence s, int start, int count, int after){}
    public void onTextChanged(CharSequence s, int start, int before, int count){
        if("second".equalsIgnoreCase(s)){
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
                    }
    }
});