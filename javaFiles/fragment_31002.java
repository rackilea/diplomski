public void onTextChanged(CharSequence s, int start, int before, int count) {
    if (autoComplete.getThreashold() < s.length()) {
        return;
    } 
    queryWebService();
}