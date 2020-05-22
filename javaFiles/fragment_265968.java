EditText editText = (EditText)findViewById(R.id.editText);
final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);
editText.addTextChangedListener(new TextWatcher(){
    public void afterTextChanged(Editable s) {
        progressbar.setVisibility(View.GONE);
    }
    public void beforeTextChanged(CharSequence s, int start, int count, int after){}
    public void onTextChanged(CharSequence s, int start, int before, int count){}
});