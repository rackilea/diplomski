EditText searchTo = (EditText)findViewById(R.id.medittext);
searchTo.addTextChangedListener(new TextWatcher() {

    @Override
    public void afterTextChanged(Editable s) {
        // TODO Auto-generated method stub

//here you check for your conditions...

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        doSomething();



    } 

});