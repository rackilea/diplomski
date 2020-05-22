final EditText edittext = (EditText) findViewById(R.id.edit);

edittext.addTextChangedListener(new TextWatcher() {

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (before == 0 && count == 1 && s.charAt(start) == '\n') {
            String text = edittext.getText().replace(start, start + 1, "").toString(); // Removes the enter
            Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void afterTextChanged(Editable s) {
    }
});