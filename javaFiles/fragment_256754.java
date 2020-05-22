boolean et1HasText, et2HasText, et3HasText; // Global variables
et1.addTextChangedListener(new TextWatcher() {
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        if(s.length > 0){ 
            et1HasText = true;
        }else{
            et1HasText = false;
        }
        validateButton();
}
// Other callbacks
...
...
});

et2.addTextChangedListener(new TextWatcher() {
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        if(s.length > 0){ 
            et2HasText = true;
        }else{
            et2HasText = false;
        }
        validateButton();
}
//Other callbacks
...
...
});

et3.addTextChangedListener(new TextWatcher() {
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        if(s.length > 0){ 
            et3HasText = true;
        }else{
            et3HasText = false;
        }
        validateButton();
}
//Other callbacks
...
...

});

private void validateButton(){
    if(et1HasText && et2HasText && et3HasText){
    //Enable the button only when all the 3 edit texts have text
        button.setEnabled(true);
    }else{
    //Disable otherwise (user clicks backspace and clears the edit text etc)
        button.setEnabled(false);
    }
}