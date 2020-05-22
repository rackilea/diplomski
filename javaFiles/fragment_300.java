edittext.addTextChangedListener(new TextWatcher() {

public void onTextChanged(CharSequence s, int start, int before,
        int count) {
        if(list.contains(s)) { 
            //do your work here 
        }
}



public void beforeTextChanged(CharSequence s, int start, int count,
        int after) {

}

public void afterTextChanged(Editable s) {

}