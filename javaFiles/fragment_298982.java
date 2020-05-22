editText = (EditText) findViewById(R.id.edit_text);

editText.setOnEditorActionListener(new OnEditorActionListener() {
    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            // do your stuff here
        }
        return false;
    }
});