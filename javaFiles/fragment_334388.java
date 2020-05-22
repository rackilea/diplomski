public  class CustomTextWatcher implements TextWatcher {
    private String [] text;
    public CustomTextWatcher(String[] text) {
        this.text = text;
    }

    @Override
    public void afterTextChanged(Editable s) {
        text[0] = (String) s.toString();
    }

    @Override
    public void beforeTextChanged(CharSequence arg0, int arg1,
        int arg2, int arg3) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before,
        int count) {}
}