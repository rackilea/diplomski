inputSearch.addTextChangedListener(new TextWatcher() {

    @Override
    public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
        // When user changed the Text
        MainActivity.this.adapter.getFilter().filter(cs);   
    }

    @Override
    public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
            int arg3) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterTextChanged(Editable arg0) {
        // TODO Auto-generated method stub                          
    }
});