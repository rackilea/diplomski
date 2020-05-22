private void someTestMethodName() {
    AutoCompleteTextView tagSearchInput = findViewById(R.id.autoCompleteTextView);
    showSoftKeyboard(tagSearchInput);
}

public void showSoftKeyboard(View view){
    if(view.requestFocus()){
        InputMethodManager imm =(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view,InputMethodManager.SHOW_IMPLICIT);
    }
}